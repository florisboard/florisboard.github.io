# FlorisBoard Website

This repo contains all the necessary config files, assets, layouts and the actual content of the [FlorisBoard website](https://florisboard.org).

This website is built using the static website framework [Zola](https;//getzola.org/), with the [duckquill](https://codeberg.org/daudix/duckquill) theme installed.

The resulting webpage is entirely static (HTML/CSS only, no server-side code) and deployed to the GitHub Pages environment automatically.

## Building the website locally

1. [Install Zola](https://www.getzola.org/documentation/getting-started/installation/)
2. Clone this repo (`git clone https://github.com/florisboard/florisboard.github.io`) and `cd` into it
3. Run `git submodule update --init`
4. Run `zola serve`
5. Open http://localhost:1111/ in your browser

## License

This website and its contents are licensed under the [Apache 2.0 license](LICENSE):

```
Copyright 2022-2025 Patrick Goldinger and Lars Mühlbauer

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
