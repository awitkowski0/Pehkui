
# Pehkui
Library mod for the Fabric, Forge, and Quilt mod loaders that allows mod developers to modify the size of entities.  

# Information for Players
<details open>
<summary>Show/Hide Information for Players</summary><table width=100%><td>

## Required Mods to Run
<details open>
<summary>Show/Hide Required Mods</summary><table width=100%><td>

### Playing on Fabric

- Newest version of the [Fabric mod loader](https://fabricmc.net/use/installer/)  
- Newest version of the [Fabric A](https://www.curseforge.com/minecraft/mc-mods/fabric-api/files/all)[PI mod](https://modrinth.com/mod/fabric-api/versions) for whichever Minecraft version you're playing on

### Playing on Forge

- Newest version of the [Forge mod loader](https://files.minecraftforge.net/net/minecraftforge/forge/) for whichever Minecraft version you're playing on

### Playing on Quilt

- Newest version of the [Quilt mod loader](https://quiltmc.org/en/install/)  
- Newest version of the [Quilt Stan](https://www.curseforge.com/minecraft/mc-mods/qsl/files/all)[dard Libraries](https://modrinth.com/mod/qsl/versions) for whichever Minecraft version you're playing on
</td></table></details>

## Supported Minecraft Versions
<details>
<summary>Show/Hide Supported Minecraft Versions</summary><table width=100%><td>

### Fabric/Quilt Versions
Supported Versions of `Pehkui-x.y.z+1.14.4-1.20`:  
`1.20`, `1.19.4`, `1.19.3`, `1.19.2`, `1.18.2`, `1.17.1`, `1.16.5`, `1.15.2`, `1.14.4`

### Forge Versions

Supported Versions of `Pehkui-x.y.z+1.20-forge`:  
`1.20`

Supported Versions of `Pehkui-x.y.z+1.19.4-forge`:  
`1.19.4`

Supported Versions of `Pehkui-x.y.z+1.19.3-forge`:  
`1.19.3`

Supported Versions of `Pehkui-x.y.z+1.19.2-forge`:  
`1.19.2`

Supported Versions of `Pehkui-x.y.z+1.18.2-forge`:  
`1.18.2`

Supported Versions of `Pehkui-x.y.z+1.17.1-forge`:  
`1.17.1`

Supported Versions of `Pehkui-x.y.z+1.16.5-forge`:  
`1.16.5`

</td></table></details>

## Mod Features
<details>
<summary>Show/Hide Mod Features</summary><table width=100%><td></br>

Pehkui allows mod developers to:

- Change the size of entities through modifying scale data
- Affect other properties of an entity that are considered as dependant on the size</br>(e.g. movement speed, explosion size, reach distance)
- Have the scalable properties of an entity be affected by other scale data types or by</br>external data through scale modifiers
</td></table></details>
</td></table></details>

# Information for Developers
<details>
<summary>Show/Hide Information for Developers</summary><table width=100%><td>

## Adding a Dependency
<details open>
<summary>Show/Hide Dependency Information</summary><table width=100%><td>

### Maven

<details open>
<summary>Show/Hide Maven Information</summary><table width=100%><td>

To make use of Pehkui in your own mod, you'll first need to go to the `repositories`</br>block of your `build.gradle`, typically found right before the `dependencies` block,</br>and add the JitPack Maven to the bottom of the block like below:

```groovy
// ...

repositories {
	// ... your other Maven repositories above, if any ...
	maven {
		url = "https://jitpack.io"
	}
}

dependencies {
	// ...
}

// ...
```
</td></table></details>

### Mod Version and Dependency Configuration

<details open>
<summary>Show/Hide Dependency Configuration Information</summary><table width=100%><td>

Now that a Maven repository is specified, add `pehkui_version=x.y.z-w` to your</br>`gradle.properties`, replacing `x.y.z-w` with one of the available version strings from the</br>[list of release tags](../../../tags).

Lastly, in your `build.gradle`'s `dependencies` block, add the corresponding line from</br>below depending on your mod loader:

#### Developing for Fabric with Loom

```groovy
modApi("com.github.Virtuoel:Pehkui:${pehkui_version}", {
	exclude group: "net.fabricmc.fabric-api"
})
```

#### Developing for Forge with ForgeGradle

```groovy
implementation fg.deobf("com.github.Virtuoel:Pehkui:${pehkui_version}")
```

#### Developing for Forge with Architectury Loom

```groovy
modApi("com.github.Virtuoel:Pehkui:${pehkui_version}")
```
</td></table></details>

### Fixing Mixins of Dependencies If Using ForgeGradle

<details>
<summary>Show/Hide Fix on ForgeGradle</summary><table width=100%><td>

If you're using Forge with ForgeGradle, make sure the `mixingradle` plugin is present and</br>applied:

Make sure the following line is present in your `build.gradle`'s</br>`buildscript { repositories {} }` block.

```groovy
maven { url = "https://repo.spongepowered.org/repository/maven-public/" }
```

Then make sure the following line is present in your `build.gradle`'s `buildscript { dependencies {} }` block.

```groovy
classpath "org.spongepowered:mixingradle:0.7-SNAPSHOT"
```

Next, make sure the following line is present in your `build.gradle`.

```groovy
apply plugin: "org.spongepowered.mixin"
```

Then regenerate your run configurations with `genEclipseRuns`, `genIntellijRuns`, or</br>`genVSCodeRuns` depending on your IDE.
</td></table></details>
<details>

<summary>Show/Hide Fix on Older ForgeGradle (4 and below)</summary><table width=100%><td>

If you're using Forge with ForgeGradle 4 or older, make sure refmap remapping is enabled in your `build.gradle`'s run</br>configuration blocks.

Make sure the following lines are present in the `client {}`, `server {}`, and `data {}` run configuration blocks.

```groovy
property 'mixin.env.remapRefMap', 'true'
property 'mixin.env.refMapRemappingFile', "${projectDir}/build/createSrgToMcp/output.srg"
```

Then regenerate your run configurations with `genEclipseRuns`, `genIntellijRuns`, or</br>`genVSCodeRuns` depending on your IDE.
</td></table></details>
</td></table></details>
<!--
## API Information
<details>
<summary>Show/Hide API Information</summary><table width=100%><td>

### WIP

</td></table></details>
-->
</td></table></details>
