---
title: How to import fonts and images
applies_to: v0.5 or newer
---

FlorisBoard supports custom fonts and images in themes.
However before they can be used in the theme extension they need to be added as assets to the extension.

## Managing archive files

First, open an existing theme extension or create a new one.
This page gives the option to manage the theme extensions archive files.
<img alt="Manage Archive files" src="/assets/images/themes/manage_archive_files.png" height="10px"/>

By clicking on the ${.components.widgets.BootstrapIcon("plus-lg")} add a font/image to the archive.
Renaming and deleting assets is possible by clicking on the filename in this list.

## Add a background image to a theme

Background images are only applicable on the `window` rule.
Add a new `background-image` property to the `window` rule.
For the background-image property, select Uri reference as the value type.
Click on the find file icon, to select the image file.

## Add a custom font to a theme

Follow the steps in the [fonts](fonts#custom-fonts) section.

<table-of-contents />
