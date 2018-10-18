## Get Started

Create `config.json` file

```
var CONFIG = {
	CSDK_CLIENT_ID: "<YOUR_API_KEY_HERE>"
}
```

To create `server.pem` file

```
$ openssl req -new -x509 -keyout server.pem -out server.pem -days 365 -nodes
```

Start https://localhost:4443/

```
$ python https-server.py
```
