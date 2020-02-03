<!DOCTYPE html>
<html>
<head data-suburl="">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	
		<meta name="author" content="coding-422" />
		<meta name="description" content="copy-422 - 这是慕课网官方实战课【CID 422-新版微服务时代Spring Boot企业微信点餐系统】的项目组织" />
		<meta name="keywords" content="慕课网Git,代码托管,Git,Git代码托管,实战课源码">
	
	<meta name="referrer" content="no-referrer-when-downgrade" />
	<meta name="_csrf" content="8m6UuhPfVWyyBo6kzNg00uWUBPM6MTU4MDcxMzI1MDE2NzM3MjgyOA==" />
	<meta name="_suburl" content="" />
	
	
	
		<meta property="og:url" content="https://git.imooc.com/coding-422/copy-422" />
		<meta property="og:type" content="object" />
		<meta property="og:title" content="coding-422/copy-422">
		<meta property="og:description" content="这是慕课网官方实战课【CID 422-新版微服务时代Spring Boot企业微信点餐系统】的项目组织">
		<meta property="og:image" content="https://git.imooc.com/img/avatar_default.png" />
	
	
	<link rel="shortcut icon" href="/img/favicon.ico" />

	<script src="/js/jquery-1.11.3.min.js"></script>
	<script src="/js/libs/jquery.are-you-sure.js"></script>
	<link rel="stylesheet" href="/assets/font-awesome-4.6.3/css/font-awesome.min.css">
	<link rel="stylesheet" href="/assets/font-imooc/css/font-less.css">
	<link rel="stylesheet" href="/assets/font-imv2/css/style.css">
	<link rel="stylesheet" href="/assets/octicons-4.3.0/octicons.min.css">
	<link rel="stylesheet" href="/js/libs/moco/v1.0/dist/css/moco.min.css?v=1">
	
	

	

	
	<link rel="stylesheet" href="/css/semantic-2.2.13.min.css">
	<link rel="stylesheet" href="/css/gogs.css?v=6fc9e85aa88133794d3434ea74aa557a">
	<link rel="stylesheet" href="/css/profie.css?v=6fc9e85aa88133794d3434ea74aa557a">
	
	<script src="/js/semantic-2.2.13.min.js"></script>
	<script src="/js/gogs.js?v=6fc9e85aa88133794d3434ea74aa557a1"></script>
	<script src="/js/libs/moco/v1.0/dist/js/moco.min.js?v=1"></script>

	
	<script type = "text/javascript">
	(function() {
		window.zhuge = window.zhuge || [];
		window.zhuge.methods = "_init identify track getDid getSid getKey setSuperProperty setUserProperties setWxProperties setPlatform".split(" ");
		window.zhuge.factory = function(b) {
		return function() {
			var a = Array.prototype.slice.call(arguments);
			a.unshift(b);
			window.zhuge.push(a);
			return window.zhuge;
		}
		};
		for (var i = 0; i < window.zhuge.methods.length; i++) {
		var key = window.zhuge.methods[i];
		window.zhuge[key] = window.zhuge.factory(key);
		}
		window.zhuge.load = function(b, x) {
		if (!document.getElementById("zhuge-js")) {
			var a = document.createElement("script");
			var verDate = new Date();
			var verStr = verDate.getFullYear().toString() + verDate.getMonth().toString() + verDate.getDate().toString();

			a.type = "text/javascript";
			a.id = "zhuge-js";
			a.async = !0;
			a.src = (location.protocol == 'http:' ? "http://sdk.zhugeio.com/zhuge.min.js?v=": 'https://zgsdk.zhugeio.com/zhuge.min.js?v=') + verStr;
			a.onerror = function() {
			window.zhuge.identify = window.zhuge.track = function(ename, props, callback) {
				if(callback && Object.prototype.toString.call(callback) === '[object Function]') {
				callback();
				} else if (Object.prototype.toString.call(props) === '[object Function]') {
				props();
				}
			};
			};
			var c = document.getElementsByTagName("script")[0];
			c.parentNode.insertBefore(a, c);

			window.zhuge._init(b, x)
		}
		};
			window.zhuge.load('f375fe2f71e542a4b890d9a620f9fb32', {
				superProperty: {
					'应用名称': '诸葛io'
				},
				debug: false,
				adTrack: false,
				autoTrack: false,
				singlePage: false
			});
	})();
	</script>

	<title>coding-422/copy-422: 这是慕课网官方实战课【CID 422-新版微服务时代Spring Boot企业微信点餐系统】的项目组织 - 慕课网Git</title>

	<meta name="theme-color" content="#ff5343">

	

</head>
<body>
	<div class="full height">
		<noscript>Please enable JavaScript in your browser!</noscript>

		
			<div class="following bar gray">

				<div class="ui container">
					<div class="ui grid">
						<div class="column">
							<div class="ui top secondary menu definemenu">
								<a class="item brand" href="/">
									<img class="ui mini image" src="/img/favicon.png">
								</a>

								
									<a class="item" href="/issues">任务管理</a>
									<a class="item" href="/pulls">合并请求</a>
								

								<a class="item" href="/explore/repos" style="display: none;">发现</a>

								
									<div class="right menu">
									
									
										<div class="ui dropdown head link jump item poping up" data-variation="tiny inverted" style="height: 52px;">
											<span class="text">
												<i class="octicon octicon-plus"><span class="sr-only">创建...</span></i>
												<i class="octicon octicon-triangle-down"></i>
											</span>
											<div class="menu">
												<a class="item" href="/repo/create">
													<i class="octicon octicon-plus"></i> 创建仓库
												</a>
												<a class="item" href="/repo/migrate">
													<i class="octicon octicon-repo-clone"></i> 迁移外部仓库
												</a>
												
												<a class="item" href="/org/create">
													<i class="octicon octicon-organization"></i> 创建新的组织
												</a>
												
											</div>
										</div>
									
										<div class="ui dropdown head link jump item poping up mr0" tabindex="-1" data-variation="tiny inverted">
											<span class="text avatar">
												<img class="ui avatar image" src="//img.mukewang.com/58d21ec900010b3e01000100-100-100.jpg">
												
												<i class="ellipsis vertical icon" tabindex="-1"></i>
											</span>
											<div class="menu" tabindex="-1">
												
												<a class="item" href="/Jaina">
													<i class="octicon octicon-person"></i>
													个人主页
												</a>
												<a class=" item" href="/user/settings/ssh">
													<i class="octicon octicon-settings"></i>
													用户设置
												</a>
												<a class="item" target="_blank" href="//www.imooc.com/help/cate/27" rel="noreferrer">
													<i class="octicon octicon-question"></i>
													帮助
												</a>
												

												<div class="divider"></div>
												<a  class="item" href="//git.imooc.com/passport/user/logout?referer=//git.imooc.com">
													<i class="octicon octicon-sign-out"></i>
													退出
												</a>
											</div>
										</div>
									</div>

								
							</div>
						</div>
					</div>
				</div>
			</div>
		


<div class="repository file list">
	<div class="header-wrapper">

	<div class="ui container">
		<div class="ui vertically padded grid head">
			<div class="column">
				<div class="ui header">
					<div class="ui huge breadcrumb">
						<i class="mega-octicon octicon-lock"></i>
						<a href="/coding-422">CID 422-新版微服务时代Spring Boot企业微信点餐系统</a>
						<div class="divider"> / </div>
						<a href="/coding-422/copy-422">copy-422</a>
						
						
					</div>

					
						<div class="ui right">
							<div class="ui labeled button" tabindex="0">
								<a class="ui basic button" href="/coding-422/copy-422/action/unwatch?redirect_to=%2fcoding-422%2fcopy-422%2fsrc%2fdevelop%2fdoc%2fSQL.md">
									<i class="icon fa-eye"></i>取消关注
								</a>
								<a class="ui basic label" href="/coding-422/copy-422/watchers">
									668
								</a>
							</div>
							<div class="ui labeled button" tabindex="0">
								<a class="ui basic button" href="/coding-422/copy-422/action/star?redirect_to=%2fcoding-422%2fcopy-422%2fsrc%2fdevelop%2fdoc%2fSQL.md">
									<i class="icon fa-star-o"></i>点赞
								</a>
								<a class="ui basic label" href="/coding-422/copy-422/stars">
									3
								</a>
							</div>
							
								<div class="ui labeled button" tabindex="0">
									<a class="ui basic button " href="/repo/fork/13103">
										<i class="octicon octicon-repo-forked"></i>Fork
									</a>
									<a class="ui basic label" href="/coding-422/copy-422/forks">
										38
									</a>
								</div>
							
						</div>
					
				</div>
			</div>
		</div>
	</div>


	<div class="ui tabs container">
		<div class="ui tabular menu navbar">
			
				<a class="active item" href="/coding-422/copy-422">
					<i class="octicon octicon-file-text"></i> 代码
				</a>
			
			
				<a class=" item" href="/coding-422/copy-422/issues">
					<i class="octicon octicon-issue-opened"></i> Issues <span class="ui small label">0</span>
				</a>
			
			
				<a class=" item" href="/coding-422/copy-422/pulls">
					<i class="octicon octicon-git-pull-request"></i> Pull Requests <span class="ui small label">0</span>
				</a>
			
			
				<a class=" item" href="/coding-422/copy-422/wiki">
					<i class="octicon octicon-book"></i> Wiki
				</a>
			
			
		</div>
	</div>
	<div class="ui tabs divider"></div>

</div>

	<div class="ui container">
		




		
		<div class="ui secondary menu">
			<div class="fitted item choose reference">
	<div class="ui floating filter dropdown" data-no-results="未找到结果">
			<div class="ui basic small button">
			<span class="text">
				<i class="octicon octicon-git-branch"></i>
				分支:
				<strong class="branch_text">develop</strong>
			</span>
			<i class="dropdown icon"></i>
		</div>
		<div class="menu">
			<div class="ui icon search input">
				<i class="filter icon"></i>
				<input name="search" placeholder="过滤分支或标签...">
			</div>
			<div class="header">
				<div class="ui grid">
					<div class="two column row">
						<a class="reference column" href="#" data-target="#branch-list">
							<span class="text black">
								分支列表
							</span>
						</a>
						<a class="reference column" href="#" data-target="#tag-list">
							<span class="text ">
								标签列表
							</span>
						</a>
					</div>
				</div>
			</div>
			<div id="branch-list" class="scrolling menu" >
				
					<div class="item selected" data-url="/coding-422/copy-422/src/develop/doc/SQL.md">develop</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/master/doc/SQL.md">master</div>
				
			</div>
			<div id="tag-list" class="scrolling menu" style="display: none">
				
					<div class="item " data-url="/coding-422/copy-422/src/16-8/doc/SQL.md">16-8</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/16-5/doc/SQL.md">16-5</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/16-2/doc/SQL.md">16-2</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/13-10/doc/SQL.md">13-10</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/13-8/doc/SQL.md">13-8</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/13-7/doc/SQL.md">13-7</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/13-4/doc/SQL.md">13-4</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/13-3/doc/SQL.md">13-3</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/13-1/doc/SQL.md">13-1</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/12-10/doc/SQL.md">12-10</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/12-9/doc/SQL.md">12-9</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/12-8/doc/SQL.md">12-8</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/12-7/doc/SQL.md">12-7</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/12-6/doc/SQL.md">12-6</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/12-5/doc/SQL.md">12-5</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/12-4/doc/SQL.md">12-4</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/12-3/doc/SQL.md">12-3</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/11-4/doc/SQL.md">11-4</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/11-3/doc/SQL.md">11-3</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/10-5/doc/SQL.md">10-5</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/10-4/doc/SQL.md">10-4</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/10-3/doc/SQL.md">10-3</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/10-2/doc/SQL.md">10-2</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/9-7/doc/SQL.md">9-7</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/9-6/doc/SQL.md">9-6</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/9-5/doc/SQL.md">9-5</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/9-4/doc/SQL.md">9-4</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/9-3/doc/SQL.md">9-3</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/9-1/doc/SQL.md">9-1</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/8-7/doc/SQL.md">8-7</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/8-6/doc/SQL.md">8-6</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/8-4/doc/SQL.md">8-4</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/8-2/doc/SQL.md">8-2</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/7-7/doc/SQL.md">7-7</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/7-6/doc/SQL.md">7-6</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/6-13/doc/SQL.md">6-13</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/6-9/doc/SQL.md">6-9</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/6-2/doc/SQL.md">6-2</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/5-4/doc/SQL.md">5-4</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/5-2/doc/SQL.md">5-2</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/5-1/doc/SQL.md">5-1</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/4-3/doc/SQL.md">4-3</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/4-2/doc/SQL.md">4-2</div>
				
					<div class="item " data-url="/coding-422/copy-422/src/3-2/doc/SQL.md">3-2</div>
				
			</div>
		</div>
	</div>
</div>

			
			<div class="fitted item">
				
				
				
					<div class="ui breadcrumb">
						<a class="section" href="/coding-422/copy-422/src/develop">copy-422</a>
						
							<div class="divider"> / </div>
							
								
								<span class="section"><a href="/coding-422/copy-422/src/develop/doc">doc</a></span>
							
						
							<div class="divider"> / </div>
							
								<span class="active section">SQL.md</span>
							
						
					</div>
				
			</div>
			<div class="right fitted item">
				
					<div id="file-buttons" class="ui tiny blue buttons">
						
						
					</div>
				

				
					
			</div>
		</div>
		
			<div id="file-content" class="tab-size-8">
	<h4 class="ui top attached header" id="repo-read-file">
		
			<i class="file text outline icon ui left"></i>
			<strong>SQL.md</strong> <span class="text grey normal">3.5 KB</span>
		
		
			<div class="ui right file-actions">
				<div class="ui buttons">
					
						<a class="ui button" href="/coding-422/copy-422/src/c8d6d73349bac124fc6ef554db29230ac901be5a/doc/SQL.md">永久链接</a>
					
					<a class="ui button" href="/coding-422/copy-422/commits/develop/doc/SQL.md">文件历史</a>
					<a class="ui button" href="/coding-422/copy-422/raw/develop/doc/SQL.md">原始文件</a>
				</div>
				
					
						<i class="octicon octicon-pencil btn-octicon poping up disabled" data-content="您必须Fork此仓库才能对此文件进行修改操作" data-position="bottom center" data-variation="tiny inverted"></i>
					
					
						<i class="octicon octicon-trashcan btn-octicon poping up disabled" data-content="您必须具有可写权限才能对此文件进行修改操作" data-position="bottom center" data-variation="tiny inverted"></i>
					
				
			</div>
		
	</h4>
	<div class="ui attached table segment">
		<div id="" class="file-view markdown has-emoji">
			
				<h1>微信点餐数据库</h1>

<pre><code class="language-sql">-- 类目
create table `product_category` (
    `category_id` int not null auto_increment,
    `category_name` varchar(64) not null comment &#39;类目名字&#39;,
    `category_type` int not null comment &#39;类目编号&#39;,
    `create_time` timestamp not null default current_timestamp comment &#39;创建时间&#39;,
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment &#39;修改时间&#39;,
    primary key (`category_id`),
    UNIQUE KEY `uqe_category_type` (`category_type`)
);

-- 商品
create table `product_info` (
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment &#39;商品名称&#39;,
    `product_price` decimal(8,2) not null comment &#39;单价&#39;,
    `product_stock` int not null comment &#39;库存&#39;,
    `product_description` varchar(64) comment &#39;描述&#39;,
    `product_icon` varchar(512) comment &#39;小图&#39;,
    `product_status` tinyint(3) DEFAULT &#39;0&#39; COMMENT &#39;商品状态,0正常1下架&#39;,
    `category_type` int not null comment &#39;类目编号&#39;,
    `create_time` timestamp not null default current_timestamp comment &#39;创建时间&#39;,
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment &#39;修改时间&#39;,
    primary key (`product_id`)
);

-- 订单
create table `order_master` (
    `order_id` varchar(32) not null,
    `buyer_name` varchar(32) not null comment &#39;买家名字&#39;,
    `buyer_phone` varchar(32) not null comment &#39;买家电话&#39;,
    `buyer_address` varchar(128) not null comment &#39;买家地址&#39;,
    `buyer_openid` varchar(64) not null comment &#39;买家微信openid&#39;,
    `order_amount` decimal(8,2) not null comment &#39;订单总金额&#39;,
    `order_status` tinyint(3) not null default &#39;0&#39; comment &#39;订单状态, 默认为新下单&#39;,
    `pay_status` tinyint(3) not null default &#39;0&#39; comment &#39;支付状态, 默认未支付&#39;,
    `create_time` timestamp not null default current_timestamp comment &#39;创建时间&#39;,
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment &#39;修改时间&#39;,
    primary key (`order_id`),
    key `idx_buyer_openid` (`buyer_openid`)
);

-- 订单商品
create table `order_detail` (
    `detail_id` varchar(32) not null,
    `order_id` varchar(32) not null,
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment &#39;商品名称&#39;,
    `product_price` decimal(8,2) not null comment &#39;当前价格,单位分&#39;,
    `product_quantity` int not null comment &#39;数量&#39;,
    `product_icon` varchar(512) comment &#39;小图&#39;,
    `create_time` timestamp not null default current_timestamp comment &#39;创建时间&#39;,
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment &#39;修改时间&#39;,
    primary key (`detail_id`),
    key `idx_order_id` (`order_id`)
);

-- 卖家(登录后台使用, 卖家登录之后可能直接采用微信扫码登录，不使用账号密码)
create table `seller_info` (
    `seller_id` varchar(32) not null,
    `username` varchar(32) not null,
    `password` varchar(32) not null,
    `openid` varchar(64) not null comment &#39;微信openid&#39;,
    `create_time` timestamp not null default current_timestamp comment &#39;创建时间&#39;,
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment &#39;修改时间&#39;,
    primary key (`seller_id`)
) comment &#39;卖家信息表&#39;;

</code></pre>

<h4>样例图片链接</h4>

<pre><code>http://img1.mukewang.com/5dc3891e0001049611251125.jpg
http://img1.mukewang.com/5dc389700001993908000800.jpg
http://img1.mukewang.com/5dc3891e000174af08000800.jpg
</code></pre>

			
		</div>
	</div>
</div>

<script>
function submitDeleteForm() {
    var message = prompt("delete_confirm_message\n\ndelete_commit_summary", "Delete ''");
    if (message != null) {
        $("#delete-message").val(message);
        $("#delete-file-form").submit()
    }
}
</script>

		
	</div>
</div>

	</div>
	
	<div id="J_GotoTop" class="elevator">
		<a href="//www.imooc.com/user/feedback" class="elevator-msg" target="_blank">
			<i class="imv2-feedback"></i>
			<span class="">意见反馈</span>
		</a>
		<a href="//www.imooc.com/help/cate/27" class="elevator-faq" target="_blank">
			<i class="imv2-help icon blue"></i>
			<span class="">帮助中心</span>
		</a>
		
		<a href="javascript:void(0)" class="elevator-weixin no-goto" id="js-elevator-weixin" >
			<i class="imv2-weixigzh"></i>
			<span class="">官方微信</span>
			<div class="elevator-weixin-box"></div>
		</a>
		<a href="javascript:void(0)" class="elevator-top no-goto" style="display:none" id="backTop">
			<i class="imv2-arrow2_u"></i>
			<span class="">返回顶部</span>
		</a>
	</div>
	<footer>
		<div class="ui container">
			<div class="ui left">Copyright © 2018 imooc.com All Rights Reserved | 京ICP备 12003892号-11</div>
			<div class="ui right links">
				<div class="ui language bottom floating upward slide up dropdown link item">
					<i class="world icon"></i>
					<div class="text">简体中文</div>
					<div class="menu">
						
							<a class="item active selected" href="#">简体中文</a>
						
							<a class="item " href="/coding-422/copy-422/src/develop/doc/SQL.md?lang=en-US">English</a>
						
							<a class="item " href="/coding-422/copy-422/src/develop/doc/SQL.md?lang=zh-HK">繁體中文</a>
						
					</div>
				</div>
			</div>
		</div>
	</footer>

<script>
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?f0cfcccd7b1393990c78efdeebff3968";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
<script>
(function(){
    var bp = document.createElement('script');
    var curProtocol = window.location.protocol.split(':')[0];
    if (curProtocol === 'https') {
        bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';        
    }
    else {
        bp.src = 'http://push.zhanzhang.baidu.com/push.js';
    }
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(bp, s);
})();
</script>


<div style="display: none;">
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?84d74dc9bf9efbc24efce88f71f831cb";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>

</div>
</body>



	<link rel="stylesheet" href="/plugins/highlight-9.6.0/github.css">
	<script src="/plugins/highlight-9.6.0/highlight.pack.js"></script>




<script src="/js/libs/emojify-1.1.0.min.js"></script> 
<script src="/js/libs/clipboard-1.5.9.min.js"></script>

</html>

