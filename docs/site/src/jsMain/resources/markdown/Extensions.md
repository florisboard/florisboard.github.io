---
title: Creating and Packaging Extensions
appliesTo: v0.4.0-beta03 or newer
---

---

## Creating extensions

For now only theme extensions can be dynamically created, language packs and keyboard extensions are only partially functional and only possible for the built-in extensions. Generally though you can create extensions both in-app or on a desktop, both approaches have their pros and cons, although in-app is recommended for beginners.

### In-app

Go to Addons & Extensions > Theme extensions and click "Create Extension". There you can manage meta data, and also add theme stylesheets. Click on the plus besides "Bundled themes" to get started. Then choose which theme to base the stylesheet on. You can also create a new stylesheet from scratch, but this is not recommended! Once you chose the theme click "Create" and the theme stylesheet has been created. You can then click "Edit" on the theme to adjust the stylesheet meta data and the theme itself using the built-in theme editor.

### On desktop

Primarily intended if you already know what you are doing or if you have development experience, this approach gives you maximum control and flexibility in the structure of your extension. It is best that you use an existing extension as a baseline, either create one in-app and export it or use the [built-in theme extension structure](https://github.com/florisboard/florisboard/tree/master/app/src/main/assets/ime/theme/org.florisboard.themes) as a base.

## Packaging extensions

To distribute an extension, you need to properly package it. An extension generally consists of an extension meta data and the extension-specific files, e.g. stylesheets, dictionaries, layouts, etc..

### Extension meta data

Regardless of the extension type each extension MUST have an `extension.json` file present in its root directory. This index file indicates important information regarding the extension, such as the type, its meta data and config. A typical `extension.json` file looks like this:

```json
{
  "$": "ime.extension.<type>",
  "meta": {
    "id": "<my_extension_id>",
    "version": "<version_str>",
    "title": "...",
    "description": "...",
    "keywords": ["...", "...", ...],
    "maintainers": ["...", "...", ...],
    "license": "<license_id>"
  },
  ... extension type specific config ...
}
```

Where
- `<type>` can be one of the following: `theme`
- `<my_extension_id>` must follow the package name rules as stated in the [publishing requirements](https://github.com/florisboard/florisboard/wiki/How-to-publish-on-FlorisBoard-Addons#publishing-requirements)
- `<license_id>` is an FSF or OSI license identifier

### Other config fields and files

Depending on the type of extension there can be other config fields or files present in the extension archive.

#### Theme extension specific files & fields

For theme extensions, you can additionally specify a themes array in the `extension.json` file, which allows you defining the stylesheets of your theme extension:

```json
{
  "themes": [
    {
      "id": "<theme_id>",
      "label": "...",
      "authors": [ ... ],
      "isNight": false
    }
    ...
  ]
}
```

Then place your stylesheet in `stylesheets/<theme_id>.json` and the app will automatically load the stylesheet from this path.
