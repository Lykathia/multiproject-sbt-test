# multiproject-sbt-test
Figuring out how to have multiple projects with no base root project.

The idea behind this is to have a root build that reaches into a specified
subproject as if it were the root project itself. So instead of always having
to call something like ```sbt subproject/run``` one could instead just run
```sbt run```.

Only useful if that subproject is the main entry point to all the subprojects,
but hey -- prototypes gotta cut corners somewhere. ;)

Instructions
------------

Just run ```sbt run``` or ```sbt build``` or whatever. I dunno man, just look in
the main [build.sbt](build.sbt) file to see what's going on.

Extra
-----

This is what the error message looks like if you don't have a root project defined.

```
[warn] No main class detected
java.lang.RuntimeException: No main class detected.
    at scala.sys.package$.error(package.scala:27)
    [trace] Stack trace suppressed: run last multiproject-sbt-test/compile:run for the full output.
    [error] (multiproject-sbt-test/compile:run) No main class detected.
    [error] Total time: 0 s, completed Feb 20, 2015 10:56:13 PM
```

If you're trying to do this with a play project, you might end up getting something that
looks like this (see [issue 3484](https://github.com/playframework/playframework/issues/3484)):

```
[error] application - 

! Internal server error, for (GET) [/] ->

java.util.NoSuchElementException: None.get
    at scala.None$.get(Option.scala:313) ~[scala-library-2.11.5.jar:na]
    at scala.None$.get(Option.scala:311) ~[scala-library-2.11.5.jar:na]
    at play.PlayReloader$$anon$1.reload(PlayReloader.scala:89) ~[na:na]
    at play.core.ReloadableApplication$$anonfun$get$1.apply(ApplicationProvider.scala:122) ~[play_2.11-2.3.5.jar:2.3.5]
    at play.core.ReloadableApplication$$anonfun$get$1.apply(ApplicationProvider.scala:120) ~[play_2.11-2.3.5.jar:2.3.5]
[warn] play - No application found at invoker init
```
