(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./$$_lazy_route_resource lazy recursive":
/*!******************************************************!*\
  !*** ./$$_lazy_route_resource lazy namespace object ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./node_modules/raw-loader/index.js!./src/app/app.component.html":
/*!**************************************************************!*\
  !*** ./node_modules/raw-loader!./src/app/app.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container-fluid\">\n  <h1>Loan application form</h1>\n  <form #userForm=\"ngForm\" *ngIf=\"!submited\" (ngSubmit)=\"onSubmit()\" novalidate>\n\n    {{ userForm.value | json }}\n    <hr />\n    {{userModel | json}}\n    <div class=\"form-group\">\n      <label>First Name</label>\n      <input type=\"text\" required minlength=\"2\" #firstName=\"ngModel\" \n        [class.is-invalid]=\"firstName.invalid && firstName.touched\" class=\"form-control\" \n        name=\"firstName\" [(ngModel)]=\"userModel.firstName\">\n      <small class=\"text-danger\" [class.d-none]=\"firstName.valid || firstName.untouched\">First name is a required and should be at least 2 character long.</small>\n    </div>\n\n\n    <div class=\"form-group\">\n      <label>Last Name</label>\n      <input type=\"text\" required minlength=\"2\" #lastName=\"ngModel\" \n      [class.is-invalid]=\"lastName.invalid && lastName.touched\" class=\"form-control\" \n        name=\"lastName\" [(ngModel)]=\"userModel.lastName\">\n      <small class=\"text-danger\" [class.d-none]=\"lastName.valid || lastName.untouched\">Last name is a required and should be at least 2 character long.</small>\n    </div>\n\n\n\n    <div ngModelGroup=\"address\">\n      <div class=\"form-group\">\n        <label>Street</label>\n        <input type=\"text\" class=\"form-control\" name=\"street\" ngModel>\n      </div>\n      \n      <div class=\"form-group\">\n        <label>Street 2 (optional)</label>\n        <input type=\"text\" class=\"form-control\" name=\"street2\" ngModel>\n      </div>\n      <div class=\"form-group\">\n        <label>City</label>\n        <input type=\"text\" class=\"form-control\" name=\"city\" ngModel>\n      </div>\n      <div class=\"form-group\">\n          <label>Select State</label>\n        <select required #state=\"ngModel\" class=\"custom-select\" name=\"state\" ngModel>\n          <option value>Select state</option>\n          <option *ngFor=\"let state of states\">{{state}}</option>\n        </select>\n      </div>\n      <div class=\"form-group\">\n          <label>Credit Score</label>\n          <input type=\"text\" class=\"form-control\" name=\"creditScore\" ngModel>\n        </div>\n    </div>\n\n\n\n    <div class=\"form-group\">\n      <label>Email</label>\n      <input type=\"email\" required minlength=\"5\" #email=\"ngModel\"\n      [class.is-invalid]=\"email.invalid && email.touched\" class=\"form-control\" \n      name=\"email\" [(ngModel)]=\"userModel.email\">\n      <small class=\"text-danger\" [class.d-none]=\"email.valid || email.untouched\">A valid email is required.</small>\n    </div>\n\n    <div class=\"form-group\">\n      <label>Phone Number</label>\n      <input type=\"tel\" #phone=\"ngModel\" pattern=\"^\\d{10}$\" required\n        [class.is-invalid]=\"phone.invalid && phone.touched\"  class=\"form-control\" name=\"phone\" (ngModel)=\"userModel.phone\">\n        <small class=\"text-danger\" [class.d-none]=\"phone.valid || phone.untouched\">Phone number must be 10 digits long.</small>\n      </div>\n\n      <label>Age</label>\n    <div class=\"form-group\">\n        \n      <select class=\"custom-select\" (blur)=\"validateAge(age.value)\" (change)=\"validateAge(age.value)\" #age=\"ngModel\" [class.is-invalid]=\"ageHasError && age.touched\" name=\"age\" [(ngModel)]=\"userModel.age\">\n        <option value=\"default\">Please enter your age</option>\n        <option *ngFor=\"let age of ages\">{{age}}</option>\n      </select>\n      <small class=\"text-danger\" [class.d-none]=\"!ageHasError || age.untouched\">Please indicate your age.</small>\n    </div>\n\n    <button class=\"btn btn-primary\" [disabled]=\"userForm.form.invalid || ageHasError\" type=\"submit\">Submit loan application</button>\n  </form>\n\n  <div class=\"alert alert-danger\" *ngIf=\"errorMsg\">\n    {{errorMsg}}\n  </div>\n</div>"

/***/ }),

/***/ "./src/app/app-routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");



var routes = [];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_2__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FwcC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _user__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./user */ "./src/app/user.ts");
/* harmony import */ var _enrollment_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./enrollment.service */ "./src/app/enrollment.service.ts");




var AppComponent = /** @class */ (function () {
    function AppComponent(_enrollmentService) {
        this._enrollmentService = _enrollmentService;
        this.userModelll = { "variables": {
                "creditScore": { "value": 700, "type": "integer" }
            } };
        this.title = 'bank loan application';
        this.ages = [16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
            51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
            71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
            91, 92, 93, 94, 95, 96, 97, 98, 99, 100];
        this.states = ["Alabama", "Arkansas", "Arizona", "Alaska", "California", "Colorado", "Connecticut",
            "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
            "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi",
            "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
            "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island",
            "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington",
            "West Virginia", "Wisconsin", "Wyoming"];
        this.userModel = new _user__WEBPACK_IMPORTED_MODULE_2__["User"]('Iurie', 'Mamaliga', '123 Pine Street', 'apt A', 'Pittsburgh', 'Pennsylvania', 12345, 'test@test.com', 1231231234, 'default');
        this.ageHasError = true;
        this.submitted = false;
        this.errorMsg = '';
        this.topicHasError = true;
    }
    AppComponent.prototype.ngOnInit = function () { };
    AppComponent.prototype.validateAge = function (value) {
        if (value === 'default') {
            this.ageHasError = true;
        }
        else {
            this.ageHasError = false;
        }
    };
    AppComponent.prototype.onSubmit = function (http) {
        this._enrollmentService.enroll(this.userModelll)
            .subscribe(function (data) { return console.log('Success!', data); }, function (error) { return console.error('Error!', error); });
    };
    AppComponent.ctorParameters = function () { return [
        { type: _enrollment_service__WEBPACK_IMPORTED_MODULE_3__["EnrollmentService"] }
    ]; };
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! raw-loader!./app.component.html */ "./node_modules/raw-loader/index.js!./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./app-routing.module */ "./src/app/app-routing.module.ts");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");







var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_5__["AppComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_4__["AppRoutingModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_6__["HttpClientModule"]
            ],
            providers: [],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_5__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/enrollment.service.ts":
/*!***************************************!*\
  !*** ./src/app/enrollment.service.ts ***!
  \***************************************/
/*! exports provided: EnrollmentService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "EnrollmentService", function() { return EnrollmentService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");




var EnrollmentService = /** @class */ (function () {
    function EnrollmentService(_http) {
        this._http = _http;
        this.userr = { "variables": {
                "creditScore": { "value": 700, "type": "integer" }
            } };
        this._url = 'http://khkjh-sdfdds.apps.us-east-2.online-starter.openshift.com/rest/process-definition/key/loanApproval/start';
        this._url2 = 'http://httpbin.org/post';
        this.proxyurl = "https://cors-anywhere.herokuapp.com/";
    }
    EnrollmentService.prototype.enroll = function (user) {
        return this._http.post(this._url, this.userr);
    };
    EnrollmentService.prototype.errorHandler = function (error) {
        return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["throwError"])(error);
    };
    EnrollmentService.ctorParameters = function () { return [
        { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] }
    ]; };
    EnrollmentService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        })
    ], EnrollmentService);
    return EnrollmentService;
}());



/***/ }),

/***/ "./src/app/user.ts":
/*!*************************!*\
  !*** ./src/app/user.ts ***!
  \*************************/
/*! exports provided: User */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "User", function() { return User; });
var User = /** @class */ (function () {
    function User(firstName, lastName, street, street2, city, state, creditScore, email, phone, age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.creditScore = creditScore;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }
    User.ctorParameters = function () { return [
        { type: String },
        { type: String },
        { type: String },
        { type: String },
        { type: String },
        { type: String },
        { type: Number },
        { type: String },
        { type: Number },
        { type: String }
    ]; };
    return User;
}());

;


/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /Users/iuriemamaliga/loan-app-front-end/loan-app-angular/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main-es5.js.map