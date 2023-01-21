# Demo WAR for EAP-8 deployments
Testing WAR release on EAP8

## Compiling
EAP-8 requires Java 11, project settings are defined, but command line needs to be adjusted.

- MacOS

		/usr/libexec/java_home -V
		export JAVA_HOME=$(/usr/libexec/java_home -v11.0.17)

## ToDo

1. Check versions of web.xml
2. Check versions of beans.xml
3. Check versions of faces-config.xml
4. Check forwarding of index.html