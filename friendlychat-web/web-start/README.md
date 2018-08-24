## Setup

```
$ npm -g install firebase-tools
$ firebase --version
$ firebase login
$ firebase use --add
```

## How to

### Serve Hosting

```
$ firebase serve --only hosting
```

### Add data to Database

```
$ firebase database:set / ../initial_messages.json
```

### Deploy database settings

```
$ firebase deploy --only database
```

