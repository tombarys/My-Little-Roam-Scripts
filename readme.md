# Roam Block Delete ("Self-destruct" :)

- shows a [X] button in a Roam block – pressing the "X" leads to deleting the block itself and all its children
- very useful for mobile Roam where you cannot delete block easily
- TIP: use a simple text shortcut to auto-paste the `{{roam/render: ((blockid))}})` to create the button

## Installation
- create a Clojure Code block in the Roam
- copy the code from the [selfdestruct.clj](https://github.com/tombarys/My-Little-Roam-Scripts/blob/master/src/selfdestruct.clj)
- get block id of the code block (right-click the bullet, Copy Block Ref) – you get `((something))` into clipboard
- put `{{roam/render: ((something))}}` at the end of the block you want to delete

## Example
- see video: https://cln.sh/z44xpSVkpnbDbHbinuMr
