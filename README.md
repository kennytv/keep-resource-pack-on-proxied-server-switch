# Dankness

### Go from 2 to 0 resource pack loading screens when switching proxied servers.

1.20.2 introduced a new protocol phase, being the configuration phase. In it, you can send the client resource packs
*before* they enter the world and also better communicate server switches. Unfortunately, the 1.20.2 client forcefully
unloads the current resource pack, which means on server networks with network-wide resource packs, the pack will have
to be resent on every server switch, resulting in *two* loading screens.

... This mod hackily "fixes" that by just **not reloading the resource manager when re-entering the configuration phase**,
as well as **ignoring packs that have the same hash as the already loaded one**.

## Downloads
Modrinth: https://modrinth.com/mod/keepresourcepack
Works well together with: https://modrinth.com/mod/forcecloseworldloadingscreen