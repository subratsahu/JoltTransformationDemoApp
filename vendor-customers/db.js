var vendorAcust  = require('./vendorAcust.json');
var vendorBcust = require('./vendorBcust.json');
var vendorCcust = require('./vendorCcust.json');

// and so on

module.exports = function() {
return {
    vendorAcust  : vendorAcust,
    vendorBcust : vendorBcust,
    vendorCcust : vendorCcust
// and so on
 }
}