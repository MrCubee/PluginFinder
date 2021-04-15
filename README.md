# Plugin FInder Library

## What is its use ?
**Automatically finds the current plugin instance.**

## How to use it ?
### First of all, you need to integrate it into your plugin. You can do this using:

#### Maven:
Repository:
```xml
<repositories>
    <repository>
        <id>mrcubee-minecraft</id>
        <url>http://nexus.mrcubee.net/repository/minecraft/</url>
    </repository>
</repositories>
```
Dependency:
```xml
<dependencies>  
  <dependency>
    <groupId>fr.mrcubee.minecraft.library</groupId>  
    <artifactId>plugin-finder</artifactId>  
    <version>1.0</version>  
    <scope>compile</scope>  
  </dependency>
 </dependencies>
```
#### Gradle:
Repository:
```groovy
repositories {
    maven {
        url "http://nexus.mrcubee.net/repository/minecraft/"
    }
}
```
Dependency:
```groovy
dependencies {
    compile 'fr.mrcubee.minecraft.library:plugin-finder:1.0'
}
```
### Use in the plugin.
#### Example:

```java
import fr.mrcubee.finder.plugin.PluginFinder;

public class ExampleClass {

    public void exampleFunction() {
        YouMainClass pluginInstance = PluginFinder.INSTANCE.findPlugin();
    }

}
```