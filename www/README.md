# FlorisBoard Website

This repo contains all the necessary config files, assets, layouts and the actual content of the [FlorisBoard website](https://florisboard.org).

This website is built using the static website framework [Zola](https://getzola.org/), with the [duckquill](https://codeberg.org/daudix/duckquill) theme installed.

The resulting webpage is entirely static (HTML/CSS only, no server-side code) and deployed to the GitHub Pages environment automatically.

## Building the website locally

1. [Install Zola](https://www.getzola.org/documentation/getting-started/installation/)
2. Clone this repo (`git clone https://github.com/florisboard/florisboard.github.io`) and `cd` into it
3. Run `git submodule update --init`
4. Run `zola serve`
5. Open http://localhost:1111/ in your browser
