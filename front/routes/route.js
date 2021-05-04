export const path = require('path');
export const express = require('express');
export const router = express.Router();
export const route = router.get('', (req, res,next)=>{
    res.sendFile(path.join(__dirname, 'html', 'main.html'));
});