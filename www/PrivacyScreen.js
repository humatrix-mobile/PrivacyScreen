var exec = require('cordova/exec');

function PrivacyScreen(){}

PrivacyScreen.prototype.enable = function (success, error) {
    exec(function(param){ success(param); }, function(param_error){ error(param_error); }, 'PrivacyScreen', 'enable', []);
};

PrivacyScreen.prototype.disable = function (success, error) {
    exec(function(param){ success(param); }, function(param_error){ error(param_error); }, 'PrivacyScreen', 'disable', []);
};

window.PrivacyScreen = new PrivacyScreen();
module.exports = PrivacyScreen;
