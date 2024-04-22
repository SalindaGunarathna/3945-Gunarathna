const express = require('express');
const app = express();
app.get('/', (req, res) => {
  res.json([
    {
      id: '1',
      title: 'Title 1',
      description: 'Description 1',
    }
   
  ]);
});
module.exports = app;
