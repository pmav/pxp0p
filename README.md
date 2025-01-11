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

| Features / Forms        | Square | Circle | Triangle | Semi Circle |
|-------------------------|--------|--------|----------|-------------|
| Size variation          | Yes    | Yes    | Yes      | Yes         |
| Position variation      | Yes    | Yes    | Yes      | Yes         |
| Fill color              | Yes    | Yes    | Yes      | Yes         |
| Transparency            | Yes    | Yes    | Yes      | Yes         |
| Direction (90º angle)   | No     | No     | Yes      | Yes         |
| Rotation (any angle)    | Yes    | No     | Yes      | Yes         |
| Stroke size             | Yes    | Yes    | Yes      | Yes         |
| Stroke color            | Yes    | Yes    | Yes      | Yes         |
| Cuts                    | Yes    | Yes    | Yes, 1   | No          |
| Cuts size               | Yes    | Yes    | Yes      | No          |
| Cuts color              | Yes    | Yes    | Yes      | No          |
| Center object           | Yes    | Yes    | No       | Yes         |
| Center object size      | Yes    | Yes    | No       | Yes         |
| Center object color     | Yes    | Yes    | No       | Yes         |
| Center object direction | No     | No     | No       | Yes         |

### TODO
- Abstract common code in Forms
- Add save path to command line args
- Add unit tests based on image hashs

### Resources

* https://tilda.cc/colors/
* https://usbrandcolors.com/