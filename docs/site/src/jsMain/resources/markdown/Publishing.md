---
title: How to publish on FlorisBoard Addons
applies_to: v0.4.0-beta03 or newer
---

---

This wiki page exclusively explains how to publish your own extension on the official [FlorisBoard Addons Store][store_url]. If you have questions regarding creating extensions or how to properly package them, please check out the [Creating and Packaging Extensionse](https://github.com/florisboard/florisboard/wiki/Creating-and-Packaging-Extensions) guide.

> [!NOTE]
> During the initial beta release phase the Addons Store _will_ only accept theme extensions. Uploading other types of extensions will not be approved by the reviewing team for now. Later on we plan to add support for language packs and keyboard extensions.

## Publishing requirements

To publish on the official Addons Store you need to meet a few requirements:
1) You need to have a GitHub account
2) Your extension source needs to be published in a publicly accessible source repo (on any platform or self-hosted)
3) Your extension must be published under an FSF or OSI approved license
4) Your extension must adhere to the [code of conduct](https://github.com/florisboard/florisboard/blob/master/CODE_OF_CONDUCT.md). Violations will lead to temporary bans, and in repeated cases to permanent bans across all FlorisBoard platforms and repositories.
5) Each of your extensions must be published under a valid and unique ID. It has the following requirements:<br>
   a) The general form is similar to Java™ package names and basically resembles a reverse domain<br>
   b) The ID must be prefixed with a reverse domain you own, or `io.github.<github_username>`<br>
   c) You can choose any subdomain you want, but once set and published you cannot change it again for the project
6) The extension versioning MUST follow [SemVer](https://semver.org/), else the system will not pick up your new releases

## Register Account

Head to the Addons Store and sign up using the GitHub button. We only access minimal data (user email addresses) from your account, and use your public GitHub username as the Addons Store username.

> [!NOTE]
> We may add support for login with other platforms in the future, however for now we only support GitHub.

## (Optional) Adding Custom Domains
If you plan on using a custom domain, now is the right time to add it to your account.
To add a custom domain click on your profile image and select "Domains". This is where you can manage all your verified domains. You will notice that `io.github.<github_username>` has been verified for you automatically.
To add other domains follow the instructions displayed there.

> [!IMPORTANT]
> Custom domains require DNS verification. In order to verify that you have control over a domain, you will need to add a TXT record with a verification code to your DNS records. This may take up to 30 minutes as the DNS records can take some time to propagate. If you cannot modify the DNS records of your domain yourself, please contact the admin of your domain.

## Create publishing project

To be able to publish releases of your extension, you need to create a publishing project. Click on your profile image > New project and fill out the required meta data. The extension ID is chosen and fixed in this screen, all other meta data can be changed afterwards. If for some reason you made an error, you can delete and recreate the project without any consequences.

### Create initial release

You now need to upload the flex file to the Addons Store. For this create a release from the project UI, give it an appropriate title/version and add the flex file.

> [!IMPORTANT]
> During the initial beta release phase every project change & release has to go through a manual review process by the admins. This means your project & release will be in a pending state until it has been approved by the reviewing team.

### Creating subsequent releases

Creating subsequent releases can be done in the same place as the initial release. Important is that the version string is newer than the previously provided version, else your new release won't be accepted.


[store_url]: https://beta.addons.florisboard.org
