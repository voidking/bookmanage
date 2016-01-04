var app = angular.module("voidking", [ "ngRoute", 'angularFileUpload' ]);

/**
 * 管理员登录控制器
 */
app.controller("AdminLoginCtrl", [ "$scope", "$http", function($scope, $http) {

	$scope.login = function() {
		$http({
			url : "./admin/login",
			data : {
				admin : $scope.admin
			},
			dataType : 'json',
			method : 'POST',
			headers : {
				"Content-Type" : "application/json"
			}
		}).success(function(data, status, headers, config) {
			$scope.info = data.info;// 接收返回的信息
		});
	};
} ]);
/**
 * 书籍类别列表控制器
 * 
 */
app.controller("BookKindCtrl", [ "$scope", "$http",function($scope, $http) {

	$scope.load = function() {
		$http.get("./bookKind/bookKindList").success(
				function(data, status, headers, config) {
					$scope.bookKinds = data.bookKinds;// 接收返回的信息
				});
	};

	$scope.remove = function(bookKindId) {
		$http.get("./bookKind/bookKindDelete", {
			params : {
				bookKindId : bookKindId
			}
		}).success(function(data, status, headers, config) {
			$scope.info = data.info;
			$scope.load();
		});
	};
	$scope.load();
} ]);

/**
 * 书籍类别添加控制器
 */
app.controller("BookKindAddCtrl", [ "$scope", "$http", function($scope, $http) {

	$scope.save = function() {
		$http({
			url : "./bookKind/bookKindAdd",
			data : {
				bookKind : $scope.bookKind
			},
			dataType : 'json',
			method : 'POST',
			headers : {
				"Content-Type" : "application/json"
			}
		}).success(function(data, status, headers, config) {
			$scope.info = data.info;// 接收返回的信息
		});
	};
} ]);

/**
 * 书籍种类修改控制器
 */

app.controller("BookKindUpdateCtrl", [ "$scope", "$http", "$route",
                                       function($scope, $http, $route) {

	var id = $route.current.params.id;

	$http.get("./bookKind/bookKindFind", {
		params : {
			bookKindId : id
		}
	}).success(function(data, status, headers, config) {
		$scope.bookKind = {
				id : data.bookKind.id,
				name : data.bookKind.name,
				keyword : data.bookKind.keyword,
				notice : data.bookKind.notice,
		};
	});

	$scope.save = function() {
		$http({
			url : "./bookKind/bookKindUpdate",
			data : {
				bookKind : $scope.bookKind
			},
			dataType : 'json',
			method : 'POST',
			headers : {
				"Content-Type" : "application/json"
			}
		}).success(function(data, status, headers, config) {
			$scope.info = data.info;// 接收返回的信息
		});
	};
} ]);

/**
 * 书籍基本信息控制器
 */
app.controller("BookBaseCtrl", ["$scope","$http",function($scope, $http) {

	$scope.load = function() {
		$http.get("./bookBase/bookBaseList").success(
				function(data, status, headers, config) {
					$scope.bookBases = data.bookBases;// 接收返回的信息
				});
	};

	$scope.remove = function(bookBaseId) {
		$http.get("./bookBase/bookBaseDelete", {
			params : {
				bookBaseId : bookBaseId
			}
		}).success(function(data, status, headers, config) {
			$scope.info = data.info;
			$scope.load();
		});
	};
	$scope.load();
} ]);

/**
 * 书籍基本信息添加控制器
 */
app.controller("BookBaseAddCtrl", [ "$scope", "$http", function($scope, $http) {

	$scope.save = function() {
		$http({
			url : "./bookBase/bookBaseAdd",
			data : {
				bookBase : $scope.bookBase
			},
			dataType : 'json',
			method : 'POST',
			headers : {
				"Content-Type" : "application/json"
			}
		}).success(function(data, status, headers, config) {
			$scope.info = data.info;// 接收返回的信息
		});
	};
} ]);

/**
 * 书籍基本信息编辑控制器
 */
app.controller("BookBaseUpdateCtrl", [ "$scope", "$http", "$route",
                                       function($scope, $http, $route) {

	var id = $route.current.params.id;

	// 从数据库中加载最新的记录
	$http.get("./bookBase/bookBaseFind", {
		params : {
			bookBaseId : id
		}
	}).success(function(data, status, headers, config) {
		$scope.bookBase = {
				id : data.bookBase.id,
				name : data.bookBase.name,
				author : data.bookBase.author,
				press : data.bookBase.press,
				publishdata : data.bookBase.publishdate,
				price : data.bookBase.price,
				page : data.bookBase.page,
				keyword : data.bookBase.keyword,
				registerdate : data.bookBase.registerdate,
				borrowed : data.bookBase.borrowed,
				notice : data.bookBase.notice,
				bookkind : {
					id : data.bookBase.bookkind.id
				}
		};
	});

	$scope.save = function() {
		$http({
			url : "./bookBase/bookBaseUpdate",
			data : {
				bookBase : $scope.bookBase
			},
			dataType : 'json',
			method : 'POST',
			headers : {
				"Content-Type" : "application/json"
			}
		}).success(function(data, status, headers, config) {
			$scope.info = data.info;// 接收返回的信息
		});
	};
} ]);

/**
 * 读者种类列表控制器
 */
app.controller("ReaderKindCtrl", ["$scope","$http",function($scope, $http) {

  $scope.load = function() {
	  $http.get("./readerKind/readerKindList").success(
			  function(data, status, headers, config) {
				  $scope.readerKinds = data.readerKinds;// 接收返回的信息
			  });
  };

  $scope.remove = function(readerKindId) {
	  $http.get("./readerKind/readerKindDelete", {
			  params : {
				  readerKindId : readerKindId
			  }
		  }).success(function(data, status, headers, config) {
			  $scope.info = data.info;
			  $scope.load();
		  });
	  };
	  $scope.load();
} ]);

/**
 * 读者类别添加控制器
 */
app.controller("ReaderKindAddCtrl", [ "$scope", "$http",
                                      function($scope, $http) {

	$scope.save = function() {
		$http({
			url : "./readerKind/readerKindAdd",
			data : {
				readerKind : $scope.readerKind
			},
			dataType : 'json',
			method : 'POST',
			headers : {
				"Content-Type" : "application/json"
			}
		}).success(function(data, status, headers, config) {
			$scope.info = data.info;// 接收返回的信息
		});
	};
} ]);

/**
 * 读者类别修改控制器
 */

app.controller("ReaderKindUpdateCtrl", [ "$scope", "$http", "$route",
                                         function($scope, $http, $route) {

	var id = $route.current.params.id;

	$http.get("./readerKind/readerKindFind", {
		params : {
			readerKindId : id
		}
	}).success(function(data, status, headers, config) {
		$scope.readerKind = {
				id : data.readerKind.id,
				name : data.readerKind.name,
				quantity : data.readerKind.quantity,
				validity : data.readerKind.validity,
				enddate : data.readerKind.enddate,
				notice : data.readerKind.notice,
		};
	});

	$scope.save = function() {
		$http({
			url : "./readerKind/readerKindUpdate",
			data : {
				readerKind : $scope.readerKind
			},
			dataType : 'json',
			method : 'POST',
			headers : {
				"Content-Type" : "application/json"
			}
		}).success(function(data, status, headers, config) {
			$scope.info = data.info;// 接收返回的信息
		});
	};
} ]);

/**
 * 读者基本信息控制器
 */
app.controller("ReaderBaseCtrl", ["$scope","$http",function($scope, $http) {

  $scope.load = function() {
	  $http.get("./readerBase/readerBaseList").success(
			  function(data, status, headers, config) {
				  $scope.readerBases = data.readerBases;// 接收返回的信息
			  });
  };

  $scope.remove = function(readerBaseId) {
	  $http.get("./readerBase/readerBaseDelete", {
			  params : {
				  readerBaseId : readerBaseId
			  }
		  }).success(function(data, status, headers, config) {
			  $scope.info = data.info;
			  $scope.load();
		  });
	  };
	  $scope.load();
} ]);

/**
 * 读者基本信息添加控制器
 */
app.controller("ReaderBaseAddCtrl", [ "$scope", "$http",
                                      function($scope, $http) {

	$scope.save = function() {
		$http({
			url : "./readerBase/readerBaseAdd",
			data : {
				readerBase : $scope.readerBase
			},
			dataType : 'json',
			method : 'POST',
			headers : {
				"Content-Type" : "application/json"
			}
		}).success(function(data, status, headers, config) {
			$scope.info = data.info;// 接收返回的信息
		});
	};
} ]);

/**
 * 读者基本信息编辑控制器
 */
app.controller("ReaderBaseUpdateCtrl", [ "$scope", "$http", "$route",
                                         function($scope, $http, $route) {

	var id = $route.current.params.id;

	// 从数据库中加载最新的记录
	$http.get("./readerBase/readerBaseFind", {
		params : {
			readerBaseId : id
		}
	}).success(function(data, status, headers, config) {
		$scope.readerBase = {
				id : data.readerBase.id,
				name : data.readerBase.name,
				sex : data.readerBase.sex,
				work : data.readerBase.work,
				address : data.readerBase.address,
				telephone : data.readerBase.telephone,
				email : data.readerBase.email,
				registerdate : data.readerBase.registerdate,
				notice : data.readerBase.notice,
				readerkind : {
					id : data.readerBase.readerkind.id
				}
		};
	});

	$scope.save = function() {
		$http({
			url : "./readerBase/readerBaseUpdate",
			data : {
				readerBase : $scope.readerBase
			},
			dataType : 'json',
			method : 'POST',
			headers : {
				"Content-Type" : "application/json"
			}
		}).success(function(data, status, headers, config) {
			$scope.info = data.info;// 接收返回的信息
		});
	};
} ]);

/**
 * 借阅信息控制器
 */
app.controller("BorrowInfoCtrl", ["$scope","$http",function($scope, $http) {

  $scope.load = function() {
	  $http.get("./borrowInfo/borrowInfoList").success(
			  function(data, status, headers, config) {
				  $scope.borrowInfos = data.borrowInfos;// 接收返回的信息
			  });
  };

  $scope.remove = function(borrowInfoId) {
	  $http.get("./borrowInfo/borrowInfoDelete", {
			  params : {
				  borrowInfoId : borrowInfoId
			  }
		  }).success(function(data, status, headers, config) {
			  $scope.info = data.info;
			  $scope.load();
		  });
	  };
	  $scope.load();
} ]);

/**
 * 借阅信息添加控制器
 */
app.controller("BorrowInfoAddCtrl", [ "$scope", "$http",
                                      function($scope, $http) {

	$scope.save = function() {
		$http({
			url : "./borrowInfo/borrowInfoAdd",
			data : {
				borrowInfo : $scope.borrowInfo
			},
			dataType : 'json',
			method : 'POST',
			headers : {
				"Content-Type" : "application/json"
			}
		}).success(function(data, status, headers, config) {
			$scope.info = data.info;// 接收返回的信息
		});
	};
} ]);

/**
 * 借阅信息编辑控制器
 */
app.controller("BorrowInfoUpdateCtrl", [ "$scope", "$http", "$route",
                                         function($scope, $http, $route) {

	var id = $route.current.params.id;

	// 从数据库中加载最新的记录
	$http.get("./borrowInfo/borrowInfoFind", {
		params : {
			borrowInfoId : id
		}
	}).success(function(data, status, headers, config) {
		$scope.borrowInfo = {
				id : data.borrowInfo.id,
				borrowdate : data.borrowInfo.borrowdate,
				returndate : data.borrowInfo.returndate,
				notice : data.borrowInfo.notice,
				readerbaseid : data.borrowInfo.readerbaseid,
				bookbaseid : data.borrowInfo.bookbaseid,
		};
	});

	$scope.save = function() {
		$http({
			url : "./borrowInfo/borrowInfoUpdate",
			data : {
				borrowInfo : $scope.borrowInfo
			},
			dataType : 'json',
			method : 'POST',
			headers : {
				"Content-Type" : "application/json"
			}
		}).success(function(data, status, headers, config) {
			$scope.info = data.info;// 接收返回的信息
		});
	};
} ]);

/**
 * 统计信息控制器
 */

app.controller("StatisticsCtrl", ["$scope","$http",function($scope, $http) {
	
  $scope.load = function() {
	  $http.get("./statistics/statistics").success(
			  function(data, status, headers, config) {
				  $scope.result1 = data.result1;// 接收返回的信息
					  $scope.result2 = data.result2;
				  });
	  };
	  $scope.load();
} ]);

/**
 * 图书检索控制器
 */
app.controller("SearchCtrl", ["$scope","$http",function($scope, $http) {

	$scope.search = function() {
		$http.get("./search/findByName",{
			params : {
				name : $scope.name
			}
		}).success(
				function(data, status, headers, config) {
					$scope.bookBases = data.bookBases;// 接收返回的信息
				});
	};

	$scope.remove = function(bookBaseId) {
		$http.get("./bookBase/bookBaseDelete", {
			params : {
				bookBaseId : bookBaseId
			}
		}).success(function(data, status, headers, config) {
			$scope.info = data.info;
			$scope.load();
		});
	};
	$scope.search();
} ]);




/**
 * 配置路由
 */
app.config([ "$routeProvider", function($routeProvider) {
	$routeProvider
	.when("/admin/login", {
		controller : "AdminLoginCtrl",
		templateUrl : "./view/admin_login.html"
	})
	.when("/bookKind", {
		controller : "BookKindCtrl",
		templateUrl : "./view/bookKind.html"
	})
	.when("/bookKind/bookKindAdd", {
		controller : "BookKindAddCtrl",
		templateUrl : "./view/bookKind_add.html"
	})
	.when("/bookKind/bookKindUpdate/:id", {
		controller : "BookKindUpdateCtrl",
		templateUrl : "./view/bookKind_update.html"
	})
	.when("/bookBase", {
		controller : "BookBaseCtrl",
		templateUrl : "./view/bookBase.html"
	})
	.when("/bookBase/bookBaseAdd", {
		controller : "BookBaseAddCtrl",
		templateUrl : "./view/bookBase_add.html"
	})
	.when("/bookBase/bookBaseUpdate/:id", {
		controller : "BookBaseUpdateCtrl",
		templateUrl : "./view/bookBase_update.html"
	})
	.when("/readerKind", {
		controller : "ReaderKindCtrl",
		templateUrl : "./view/readerKind.html"
	})
	.when("/readerKind/readerKindAdd", {
		controller : "ReaderKindAddCtrl",
		templateUrl : "./view/readerKind_add.html"
	})
	.when("/readerKind/readerKindUpdate/:id", {
		controller : "ReaderKindUpdateCtrl",
		templateUrl : "./view/readerKind_update.html"
	})
	.when("/readerBase", {
		controller : "ReaderBaseCtrl",
		templateUrl : "./view/readerBase.html"
	})
	.when("/readerBase/readerBaseAdd", {
		controller : "ReaderBaseAddCtrl",
		templateUrl : "./view/readerBase_add.html"
	})
	.when("/readerBase/readerBaseUpdate/:id", {
		controller : "ReaderBaseUpdateCtrl",
		templateUrl : "./view/readerBase_update.html"
	})
	.when("/borrowInfo", {
		controller : "BorrowInfoCtrl",
		templateUrl : "./view/borrowInfo.html"
	})
	.when("/borrowInfo/borrowInfoAdd", {
		controller : "BorrowInfoAddCtrl",
		templateUrl : "./view/borrowInfo_add.html"
	})
	.when("/borrowInfo/borrowInfoUpdate/:id", {
		controller : "BorrowInfoUpdateCtrl",
		templateUrl : "./view/borrowInfo_update.html"
	})
	.when("/statistics", {
		controller : "StatisticsCtrl",
		templateUrl : "./view/statistics.html"
	})
	.when("/search", {
		controller : "SearchCtrl",
		templateUrl : "./view/search.html"
	});
} ]);
