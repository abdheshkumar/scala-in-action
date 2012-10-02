import scala.xml._
import scala.xml.transform.{ RewriteRule, RuleTransformer }
import com.typesafe.sbteclipse.core._
import com.typesafe.sbteclipse.core.Validation

organization := "name.heikoseeberger"

name := "scala-in-action"

scalaVersion := "2.10.2"

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-language:_",
  "-target:jvm-1.7",
  "-encoding", "UTF-8"
)

libraryDependencies ++= Seq(
  "org.apache.httpcomponents" % "httpclient" % "4.2.5",
  "org.scalatest" %% "scalatest" % "2.0.RC1-SNAP4" % "test"
)

fork in run := true

Seq(          
           EclipseKeys.classpathTransformerFactories := Seq(
             new EclipseTransformerFactory[RewriteRule] {
               import scala.xml._
               override def createTransformer(ref: ProjectRef, state: State): Validation[RewriteRule] = {
                 setting(crossTarget in ref, state) map { ct =>
                   new RewriteRule {
                     override def transform(node: Node): Seq[Node] = node match {
                       case elem : Elem if (elem.label == "classpath") =>
                         val newChildren = elem.child ++ 
                           <classpathentry kind="con" path="org.eclipse.jdt.USER_LIBRARY/JavaFX"/>
                         elem.copy(child = newChildren)
                       case other =>
                         other
                     }
                   }
                 }
               }
             }))