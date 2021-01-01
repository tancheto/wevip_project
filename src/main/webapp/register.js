function register() {

    console.log("hey");

    fetch('http://localhost:8080/registerUser', {
      method: "POST",
      body: JSON.stringify({
        name: "tanya",
        surname: "haha",
        username: "foo",
        password: "bar"
      })
    });
}