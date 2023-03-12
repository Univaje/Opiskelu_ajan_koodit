const app = require('./teht6_12.js')
//const app = require('./teht1_5.js')

let port = 3004;
let hostname = "127.0.0.1";
let password = "root";
let user ="root";

app.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});
