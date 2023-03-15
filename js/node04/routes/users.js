var express = require('express');
var router = express.Router();
var session = require('express-session')
var pool = require('../modules/mysql');

router.use(session({
  secret: 'keyboard cat',
  resave: false,
  saveUninitialized: true,
  cookie: { secure: false, maxAge: 60000 }
}))

/* GET users listing. */
router.get('/login', (req, res) => {
  req.session.login = 'admin';
  console.log("/login", req.session);
  res.status(200).end();
})

router.use('/', (req, res, nxt) => {
  console.log("users/", req.session.login);
  if (req.session) nxt();
  else res.status(404);
})

router.get('/', function (req, res, next) {
  if (req.session.num)
    req.session.num++;
  else
    req.session.num = 1;

  console.log("getSession : ", req.session.num, req.session)
  const sql = "select * from dept";
  if (req.session.login) {
    const query = pool.query(sql, (err, results, fields) => {
      //res.setHeader('Content-Type','application/json;charset=utf-8');
      // res.send(results);
      res.status(200).json(results);
    });

  } else {
    res.status(403).end();
  }

  router.post('/', (req, res) => {
    const deptno = req.body.deptno;
    const dname = req.body.dname;
    const loc = req.body.loc;
    console.log(deptno, dname, loc);
    const sql = `insert into dept values(${deptno},'${dname}','${loc}')`
    pool.query(sql, (err) => {
      if (err) return res.status(500).end();
      res.status(200).end();
    })

  })

  router.get('/:deptno', (req, res) => {
    const deptno = req.params.deptno;

    const sql = `select * from dept where deptno = ${deptno}`;
    const query = pool.query(sql);
    query
      .on('error', function (err) {
        console.log(err);
      })
      .on("result", function (row) {
        console.log(row)
        res.status(200).json(row);
      })
      ;
  })

});

module.exports = router;