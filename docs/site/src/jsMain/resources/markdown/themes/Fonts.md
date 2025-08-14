---
title: Font customization
applies_to: v0.5 or newer
---

FlorisBoard offers a variety of customization options for fonts with themes.

## Font family

FlorisBoard by default uses the font installed in the system. This can be overridden with themes though. Generally,
there are two types of fonts: generic fonts, and custom fonts.

### Generic Fonts

Without any further setup, FlorisBoard supports five different font families, as shown below:

| Name         | Example                                                     |
|--------------|-------------------------------------------------------------|
| `system`     | <span>Example text.</span>                                  |
| `sans-serif` | <span style="font-family: sans-serif;">Example text.</span> |
| `serif`      | <span style="font-family: serif;">Example text.</span>      |
| `monospace`  | <span style="font-family: monospace;">Example text.</span>  |
| `cursive`    | <span style="font-family: cursive;">Example text.</span>    |

These can be

### Custom fonts

## Font size

Controls the size of the text to be rendered.

- Property name: `font-size`
- Inherits implicitly: yes

| Property value | Description                                                                                                                                                             |
|----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `<num>sp`      | Defines the font size in [scale-independent pixels](https://developer.android.com/guide/topics/resources/more-resources#Dimension).<br>`<num>` must be an integer >= 1. |

## Font style

Controls whether text is rendered in normal or italic style.

- Property name: `font-style`
- Inherits implicitly: yes

| Property value | Example                                                |
|----------------|--------------------------------------------------------|
| `normal`       | <span style="font-style: normal;">Example text.</span> |
| `italic`       | <span style="font-style: italic;">Example text.</span> |

## Font weight

Controls the weight of the text to be rendered.

- Property name: `font-weight`
- Inherits implicitly: yes

| Property value         | Example                                              |
|------------------------|------------------------------------------------------|
| `thin` or `100`        | <span style="font-weight: 100;">Example text.</span> |
| `extra-light` or `200` | <span style="font-weight: 200;">Example text.</span> |
| `light` or `300`       | <span style="font-weight: 300;">Example text.</span> |
| `normal` or `400`      | <span style="font-weight: 400;">Example text.</span> |
| `medium` or `500`      | <span style="font-weight: 500;">Example text.</span> |
| `semi-bold` or `600`   | <span style="font-weight: 600;">Example text.</span> |
| `bold` or `700`        | <span style="font-weight: 700;">Example text.</span> |
| `extra-bold` or `800`  | <span style="font-weight: 800;">Example text.</span> |
| `black` or `900`       | <span style="font-weight: 900;">Example text.</span> |



<table-of-contents />
