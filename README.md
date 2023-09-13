<center>
<img src="https://wsrv.nl/?url=https%3A%2F%2Fwww.bisecthosting.com%2Fimages%2FCF%2FAzureLib%2FBH_AL_header.png&n=-1" alt="logo"/>

<h3 align="center">AzureLib Armor is a striped-down version of <a href="https://modrinth.com/mod/azurelib">AzureLib</a> that is created just to provide its GeoArmor/GeoItem functions in a standalone library. All Armor creation steps are the same as AzureLibs armor creation as outlined <a href="https://wiki.azuredoom.com/how-to-create-animated-armor">here</a>
<br>
<br>
Are you a developer and want to use this library in your mod? Add the following to your build.gradle
</h3>
</center>


```
repositories {
    // The Maven with the mods source
    maven {url 'https://libs.azuredoom.com:4443/mods'}
}

dependencies {
    //Fabric or Quilt
    modImplementation "mod.azure.azurelibarmor:azurelibarmor-fabric-MCVERSION:MODVERSION"
		
    //NeoForge or Forge
    implementation fg.deobf("mod.azure.azurelibarmor:azurelibarmor-neo-MCVERSION:MODVERSION")
}
```


<center>

<h1 style="font-size:10vw" align="center">Wiki</h1>
<h3 align="center">
You can find the AzureLib Wiki here: https://wiki.azuredoom.com/
</h3>

<h1 style="font-size:10vw" align="center">License</h1>
<h3 align="center">
<img src="https://img.shields.io/github/license/AzureDoom/AzureLib?style=for-the-badge" alt="logo" height="70" /> 
</h3>
</center>
