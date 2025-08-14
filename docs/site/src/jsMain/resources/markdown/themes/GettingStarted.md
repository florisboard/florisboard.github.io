---
title: Getting Started
menu_position: 1
---

Customization of the FlorisBoard UI is done via themes, which describe all rules applied to the UI to customize your
keyboard to your liking. A theme may require multiple files (e.g. custom images), thus they are bundled in theme
extension archives. Whenever themes are distributed, they are thus distributed in form of an FlorisBoard theme 
extensions.

This page describes the basics on how to install theme extensions, as well as how to create new theme extensions from
the start.

## Installing themes

Theme extensions are just an archive of smaller files. They can be shared and distributed like any other file.

### From FlorisBoard Addons

FlorisBoard Addons is an official platform provided by the FlorisBoard maintainers, where we offer a platform
for sharing and discovering user-generated themes.

<!--TODO: This should be a note blockquote-->
Note: This guide only covers the installation process of themes. For publishing instructions see the
[publishing instructions](../Publishing.md).

To install themes:
1. Visit [FlorisBoard Addons][addons_url]
2. Search through the available themes
3. When you discovered a theme, download it
4. After downloading, open the file, and then choose FlorisBoard<sup>1</sup>
5. Click on Import
6. Within the FlorisBoard settings, visit Themes > Day/Night theme
7. Select a provided stylesheet from your downloaded theme extension

### From third-party sources

While FlorisBoard Addons is the recommended way for installing theme extensions, you can install them from any source.

Simply follow the following procedure:
1. Download the custom theme extension
2. After downloading, open the file, and then choose FlorisBoard<sup>1</sup>
3. Click on Import
4. Within the FlorisBoard settings, visit Themes > Day/Night theme
5. Select a provided stylesheet from your downloaded theme extension

<small>
<sup>1</sup> If you have multiple tracks of FlorisBoard installed (stable and preview), make sure you select the
correct one
</small>

## Updating themes

Updating themes is done by simply repeating the installation step. FlorisBoard will, based on the theme extension id,
match a file to be imported with an already installed theme extension and overwrite it.

If the theme extension was installed via FlorisBoard Addons, there is a helper for searching for updates. Visit
Addons & Extensions, then tap on Search for Updates. This will list all theme extensions that have a newer version
available on FlorisBoard Addons.

## Creating local themes

Theme extensions can also be created and managed in runtime. To create a new local theme extension:
1. Go to Theme > Go to Theme extensions and tap on ${.components.widgets.BootstrapIcon("plus-lg")} Create extension
2. Tap on the ${.components.widgets.BootstrapIcon("plus-lg")} next to Bundled themes
3. Choose "From existing" (You could also create an empty stylesheet, but this is not recommended)
4. Choose the stylesheet you want to copy and use as a base
5. Tap on Create
6. Tab on Save for now (customization of themes is explained later on)
7. Tada, you now have a local theme extension, that you can use the same way as an installed theme extension

<table-of-contents />

[addons_url]: https://beta.addons.florisboard.org/
