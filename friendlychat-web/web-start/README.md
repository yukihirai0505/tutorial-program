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

## Deploy

### Database settings

```
$ firebase deploy --only database
```

### Storage settings

```
$ firebase deploy --only storage
```

### App

```
$ firebase deploy --except functions
```

Open the website from CLI

```
$ firebase open hosting:site
```