# pxp0p

### Run

This project uses Maven to create an uber jar with all dependencies:
```
make build
```

After building the uber jar you can run it:
```
make run
```

### Features

List of features supported by each type of object:

| Features / Forms                 | Square | Circle | Triangle | Semi Circle |
|----------------------------------|--------|--------|----------|-------------|
| Size                             | Yes    | Yes    | Yes      | Yes         |
| Fill color                       | Yes    | Yes    | Yes      | Yes         |
| Transparency                     | Yes    | Yes    | Yes      | Yes         |
| Position variation               | Yes    | Yes    | Yes      | Yes         |
| Direction                        | No     | No     | Yes, 90º | Yes, 90º    |
| Direction function               | No     | No     | Yes, 90º | Yes, 90º    |
| Stroke size                      | Yes    | Yes    | Yes      | Yes         |
| Stroke color                     | Yes    | Yes    | Yes      | Yes         |
| Cuts                             | Yes    | Yes    | Yes, 1   | No          |
| Cuts size                        | Yes    | Yes    | Yes      | No          |
| Cuts color                       | Yes    | Yes    | Yes      | No          |
| Center object                    | Yes    | Yes    | No       | Yes         |
| Center object size               | Yes    | Yes    | No       | Yes         |
| Center object color              | Yes    | Yes    | No       | Yes         |
| Center object direction          | No     | No     | No       | Yes         |
| Center object direction function | No     | No     | No       | TODO        |

### TODO

- Add save path to command line args
- Add function to define orientation of center object

### Resources

* https://tilda.cc/colors/
* https://usbrandcolors.com/