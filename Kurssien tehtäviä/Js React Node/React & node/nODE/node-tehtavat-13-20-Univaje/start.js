//const app = require('./teht6_12.js')
//const app = require('./teht13_20.js')
//const app = require('./teht1_5.js')
//const app = require('./server.js')
const app = require('./teht13_20.js')

let port = 3004;
let hostname = "127.0.0.1";


app.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});
