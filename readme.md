# My little Roam scripts

## Table Of Contents Generator (TOC)

- script generates simple TOC in a form of list of references to H1, H2 and H3 headings which are on the first level on a page
- clicking on a TOC button clears the old TOC list (children of the block) and re-generates new list
- works only with first level headings on the first level in the page (not indented) at this time

### Installation
- create a Clojure Code block in the Roam
- copy the code from the [Roam-TOC-mini.clj](https://github.com/tombarys/My-Little-Roam-Scripts/blob/master/src/Roam-TOC-mini.clj)
- get block id of the code block (right-click the bullet, Copy Block Ref) – you get `((something))` into clipboard
- put `{{roam/render: ((something))}}` on a page which you want to generate TOC of

---

## Roam Block Delete ("Self-destruct" :)

- shows a [X] button in a Roam block – pressing the "X" leads to deleting the block itself and all its children
- very useful for mobile Roam where you cannot delete block easily
- TIP: use a simple text shortcut to auto-paste the `{{roam/render: ((blockid))}})` to create the button

### Installation
- create a Clojure Code block in the Roam
- copy the code from the [selfdestruct.clj](https://github.com/tombarys/My-Little-Roam-Scripts/blob/master/src/selfdestruct.clj)
- get block id of the code block (right-click the bullet, Copy Block Ref) – you get `((something))` into clipboard
- put `{{roam/render: ((something))}}` at the end of the block you want to delete

### Example
- see video: https://cln.sh/z44xpSVkpnbDbHbinuMr
