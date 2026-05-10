# pxp0p 🟩🔴🟨🔵🟦🟢🟥🟡

### What?
🎨 pxp0p is an art generator! 🖌️ Based on a Java configuration file, the project creates a unique image as output. 🖼️

The configuration file describes the image generated based on the forms and features that the creator wants to use, with some deterministic randomness 🎲 in the mix to keep things interesting! 🌀

Below is the list of features supported by each form and a list of examples for each form. 👇

For max fun, mix all of them! 🚀🌈🛸

---

### Features

List of features supported by each type of object:

| Features / Forms       | Square | Circle | Triangle | Semi-circle |
|------------------------|--------|--------|----------|-------------|
| Size variation         | Yes    | Yes    | Yes      | Yes         |
| Position variation     | Yes    | Yes    | Yes      | Yes         |
| Fill color             | Yes    | Yes    | Yes      | Yes         |
| Transparency           | Yes    | Yes    | Yes      | Yes         |
| Rotation (any angle)   | Yes    | No     | Yes      | Yes         |
| Stroke size            | Yes    | Yes    | Yes      | Yes         |
| Stroke color           | Yes    | Yes    | Yes      | Yes         |
| Cuts                   | Yes    | Yes    | Yes      | No          |
| Cuts size              | Yes    | Yes    | Yes      | No          |
| Cuts color             | Yes    | Yes    | Yes      | No          |
| Center object          | Yes    | Yes    | Yes      | Yes         |
| Center object size     | Yes    | Yes    | Yes      | Yes         |
| Center object color    | Yes    | Yes    | Yes      | Yes         |

---

### Examples
Examples of features being applied to each form:
- [Square](examples/square/README.md)
- [Circle](examples/circle/README.md)
- [Triangle](examples/triangle/README.md)
- [Semi-circle](examples/semicircle/README.md)

---

### Run
This project uses Maven to create an uber jar with all dependencies:
```
make build
```

After building the uber jar you can run it:
```
make run
```

---

### TODO
- Abstract common code in Forms
- Add save path to command line args
- Add unit tests based on image hash

---

### Resources
* https://tilda.cc/colors/
* https://usbrandcolors.com/


