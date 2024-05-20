<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>BudgetBuddy | 맞춤 추천</title>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
         <link type="image/png" sizes="16x16" rel="icon" href="/account/asset/images/icons8-돈-상자-16.png">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <script src="https://code.jquery.com/jquery-3.4.1.js"   
    integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="   
	crossorigin="anonymous">
    
    <link rel="stylesheet" href="/account/asset/css/combine.css">
</script>
</head>
<style>

.flipster--loop {
	  
    .flipster__item { 
      position: absolute;
    }
    
  /*  .flipster__item--past { transform: translateX(-100%); }
    .flipster__item--future { transform: translateX(100%); }*/
    
    .flipster__item--past-2 { transform: translateX(-100%); }
    .flipster__item--future-2 { transform: translateX(100%); }
    
    .flipster__item--past-1 { transform: translateX(-50%); }
    .flipster__item--future-1 { transform: translateX(50%); }
  }
  
  .flipster--infinite-carousel {
  
      .flipster__container,
      .flipster__item {
          transition: all 350ms ease-in-out;
          transition-timing-function: cubic-bezier(.56,.12,.12,.98);
      }
  
      .flipster__item__content { transition: inherit; }
  
      .flipster__item {
          position: absolute;
          opacity: 0;
          perspective: 800px;
      }
  
      .flipster__item--past-2,
      .flipster__item--future-2 {
          opacity: 0.6;
          transition-delay: 90ms;
      }
  
      .flipster__item--past-1,
      .flipster__item--future-1 {
          opacity: 0.8;
          transition-delay: 60ms;
      }
  
      .flipster__item--current {
          opacity: 1;
          transition-delay: 0;
      }
  
      .flipster__item--past .flipster__item__content,
      .flipster__item--future .flipster__item__content { transform: scale(0.4); }
  
      .flipster__item--past-2 .flipster__item__content { transform: translateX(-75%) rotateY(45deg) scale(0.6); }
      .flipster__item--future-2 .flipster__item__content { transform: translateX(75%) rotateY(-45deg) scale(0.6); }
  
      .flipster__item--past-1 .flipster__item__content { transform: translateX(-50%) rotateY(45deg) scale(0.8); }
      .flipster__item--future-1 .flipster__item__content { transform: translateX(50%) rotateY(-45deg) scale(0.8); }
  
      .flipster__item--current .flipster__item__content { transform: translateX(0) rotateY(0deg) scale(1); }
  }
  .flipster-container {
    position: relative;
}

    .description-box {
        left: 0;
        right: 0;
        padding: 10px;
        border: 1px solid #ccc;
        background-color: #f9f9f9;
    }
    img {
    width: 150px;
    height: auto;
}
    <%@include file="/WEB-INF/views/inc/asset.jsp"%>
      
</style>

<body>
    <div class="container-xxl position-relative bg-white d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Sidebar Start -->
        <!-- 사이드바  -->
        <%@include file="/WEB-INF/views/inc/card-sidebar.jsp"%>
        <!-- 사이드바 끝  -->
        <!-- Sidebar End -->


        <!-- Content Start -->
        <div class="content">
            
            <!-- Navbar Start -->
            <!-- 상당 메뉴 -->
            <%@include file="/WEB-INF/views/inc/header.jsp"%>
            <!-- 상당 메뉴 끝-->
            <!-- Navbar End -->
        <!-- Content End -->
        <!-- fakecontent 안에서 작성 -->
      <div id="content-total-style">
      	<div class="content-header">
					<div class="content-title-style">
						<h3>맞춤 추천</h3>
					</div>
			</div>
      
        <div class="flipster-container">
			<div class="flipster">
			    <ul class="flip-items">
			<c:forEach var="card" items="${recommendedCards}" varStatus="loop">
			    <li data-flip-title="${loop.index + 1}"
			     data-flip-category="${card.category}" 
			     data-description="
			     <div>
			    <div><span>카드명</span><c:out value='${card.ciName}'/></div>
			    <div><span>카드사</span> <c:out value='${card.cardCompany}'/></div>
			    <div><span>설명</span> <c:out value='${card.explanation}'/></div>
			    </div>
			    <div>
			    <div><span>연회비</span> <c:out value='${card.annualFee}'/>원</div>
			    <div><span>해외 겸용</span><c:out value='${card.overseasUse}'/></div>
			    <div><span>할인율</span><c:out value='${card.discountRate}'/>%</div>
			    </div>
			        ">
			        <img src="/account/asset/images/${card.fileLink}">
			    </li>
			</c:forEach>
			    </ul>
			</div>
        <div class="box card-recommendation-box">
            <p id="description"></p>
        </div>
    </div>
    </div>
        <!-- fakecontent 끝 -->

    </div>
    </div>

    <!-- JavaScript Libraries -->
   
    <!-- Template Javascript -->
    <script src="${pageContext.request.contextPath}/asset/css/temp/js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
    

    
    console.log("Recommended Cards: ${recommendedCards}");
    console.log("Recommended Cards Size: ${recommendedCards.size()}");
    
    
    document.addEventListener('DOMContentLoaded', function() {
    const sidebarToggler = document.getElementById('sidebar-toggler');
    const sidebar = document.querySelector('.sidebar');
    const content = document.querySelector('.content');

        sidebarToggler.addEventListener('click', function() {
        sidebar.classList.toggle('hidden');
        content.classList.toggle('expanded');
        });
    });
    
    
    /* jshint browser: true, jquery: true, devel: true */
    /* global window, jQuery */
    
    (function($, window, undefined) {
        'use strict';
    
        function throttle(func, delay) {
            var timer = null;
    
            return function() {
                var context = this,
                    args = arguments;
    
                if ( timer === null ) {
                    timer = setTimeout(function() {
                        func.apply(context, args);
                        timer = null;
                    }, delay);
                }
            };
        }
    
        // Check for browser CSS support and cache the result for subsequent calls.
        var checkStyleSupport = (function() {
            var support = {};
            return function(prop) {
                if ( support[prop] !== undefined ) { return support[prop]; }
    
                var div = document.createElement('div'),
                    style = div.style,
                    ucProp = prop.charAt(0).toUpperCase() + prop.slice(1),
                    prefixes = ["webkit", "moz", "ms", "o"],
                    props = (prop + ' ' + (prefixes).join(ucProp + ' ') + ucProp).split(' ');
    
                for (var i in props) {
                    if ( props[i] in style ) { return support[prop] = props[i]; }
                }
    
                return support[prop] = false;
            };
        }());
    
        var svgNS = 'http://www.w3.org/2000/svg',
            svgSupport = (function() {
                var support;
                return function() {
                    if ( support !== undefined ) { return support; }
                    var div = document.createElement('div');
                    div.innerHTML = '<svg/>';
                    support = ( div.firstChild && div.firstChild.namespaceURI === svgNS );
                    return support;
                };
            }());
    
        var $window = $(window),
    
            transformSupport = checkStyleSupport('transform'),
    
            defaults = {
                itemContainer: 'ul',
                // [string|object]
                // Selector for the container of the flippin' items.
    
                itemSelector: 'li',
                // [string|object]
                // Selector for children of `itemContainer` to flip
    
                start: 'center',
                // ['center'|number]
                // Zero based index of the starting item, or use 'center' to start in the middle
    
                fadeIn: 400,
                // [milliseconds]
                // Speed of the fade in animation after items have been setup
    
                loop: false,
                // [true|false|number]
                // Loop around when the start or end is reached
                // If number, this is the number of items that will be shown when the beginning or end is reached
    
                autoplay: false,
                // [false|milliseconds]
                // If a positive number, Flipster will automatically advance to next item after that number of milliseconds
    
                pauseOnHover: true,
                // [true|false]
                // If true, autoplay advancement will pause when Flipster is hovered
    
                style: 'coverflow',
                // [coverflow|carousel|flat|...]
                // Adds a class (e.g. flipster--coverflow) to the flipster element to switch between display styles
                // Create your own theme in CSS and use this setting to have Flipster add the custom class
    
                spacing: -0.6,
                // [number]
                // Space between items relative to each item's width. 0 for no spacing, negative values to overlap
    
                click: true,
                // [true|false]
                // Clicking an item switches to that item
    
                keyboard: true,
                // [true|false]
                // Enable left/right arrow navigation
    
                scrollwheel: true,
                // [true|false]
                // Enable mousewheel/trackpad navigation; up/left = previous, down/right = next
    
                touch: true,
                // [true|false]
                // Enable swipe navigation for touch devices
    
                nav: false,
                // [true|false|'before'|'after']
                // If not false, Flipster will build an unordered list of the items
                // Values true or 'before' will insert the navigation before the items, 'after' will append the navigation after the items
    
                buttons: false,
                // [true|false|'custom']
                // If true, Flipster will insert Previous / Next buttons with SVG arrows
                // If 'custom', Flipster will not insert the arrows and will instead use the values of `buttonPrev` and `buttonNext`
    
                buttonPrev: 'Previous',
                // [text|html]
                // Changes the text for the Previous button
    
                buttonNext: 'Next',
                // [text|html]
                // Changes the text for the Next button
    
                onItemSwitch: false
                // [function]
                // Callback function when items are switched
                // Arguments received: [currentItem, previousItem]
            },
    
            classes = {
                main: 'flipster',
                active: 'flipster--active',
                container: 'flipster__container',
    
                nav: 'flipster__nav',
                navChild: 'flipster__nav__child',
                navItem: 'flipster__nav__item',
                navLink: 'flipster__nav__link',
                navCurrent: 'flipster__nav__item--current',
                navCategory: 'flipster__nav__item--category',
                navCategoryLink: 'flipster__nav__link--category',
    
                button: 'flipster__button',
                buttonPrev: 'flipster__button--prev',
                buttonNext: 'flipster__button--next',
    
                item: 'flipster__item',
                itemCurrent: 'flipster__item--current',
                itemPast: 'flipster__item--past',
                itemFuture: 'flipster__item--future',
                itemContent: 'flipster__item__content'
            },
    
            classRemover = new RegExp('\\b(' + classes.itemCurrent + '|' + classes.itemPast + '|' + classes.itemFuture + ')(.*?)(\\s|$)', 'g'),
            whiteSpaceRemover = new RegExp('\\s\\s+', 'g');
    
        $.fn.flipster = function(options) {
            var isMethodCall = (typeof options === 'string' ? true : false);
    
            if ( isMethodCall ) {
                var args = Array.prototype.slice.call(arguments, 1);
                return this.each(function() {
                    var methods = $(this).data('methods');
                    if ( methods[options] ) {
                        return methods[options].apply(this, args);
                    } else {
                        return this;
                    }
                });
            }
    
            var settings = $.extend({}, defaults, options);
    
            return this.each(function() {
    
                var self = $(this),
                    methods,
    
                    _container,
                    _containerWidth,
    
                    _items,
                    _itemOffsets = [],
                    _currentItem,
                    _currentIndex = 0,
    
                    _nav,
                    _navItems,
                    _navLinks,
    
                    _playing = false,
                    _startDrag = false;
    
                function buildButtonContent(dir) {
                    var text = ( dir === 'next' ? settings.buttonNext : settings.buttonPrev );
    
                    if ( settings.buttons === 'custom' || !svgSupport ) { return text; }
    
                    return '<svg viewBox="0 0 13 20" xmlns="' + svgNS + '" aria-labelledby="title"><title>' + text + '</title><polyline points="10,3 3,10 10,17"' + (dir === 'next' ? ' transform="rotate(180 6.5,10)"' : '') + '/></svg>';
                }
    
                function buildButton(dir) {
                    dir = dir || 'next';
    
                    return $('<button class="' + classes.button + ' ' + ( dir === 'next' ? classes.buttonNext : classes.buttonPrev ) + '" role="button" />')
                        .html(buildButtonContent(dir))
                        .on('click', function(e) {
                            jump(dir);
                            e.preventDefault();
                        });
    
                }
    
                function buildButtons() {
                    if ( settings.buttons && _items.length > 1 ) {
                        self.find('.' + classes.button).remove();
                        self.append(buildButton('prev'), buildButton('next'));
                    }
                }
    
                function buildNav() {
                    var navCategories = {};
    
                    if ( !settings.nav || _items.length <= 1 ) { return; }
    
                    if ( _nav ) { _nav.remove(); }
    
                    _nav = $('<ul class="' + classes.nav + '" role="navigation" />');
                    _navLinks = $('');
    
                    _items.each(function(i) {
                        var item = $(this),
                            category = item.data('flip-category'),
                            itemTitle = item.data('flip-title') || item.attr('title') || i,
                            navLink = $('<a href="#" class="' + classes.navLink + '">' + itemTitle + '</a>')
                            .data('index', i);
    
                        _navLinks = _navLinks.add(navLink);
    
                        if ( category ) {
    
                            if ( !navCategories[category] ) {
    
                                var categoryItem = $('<li class="' + classes.navItem + ' ' + classes.navCategory + '">');
                                var categoryLink = $('<a href="#" class="' + classes.navLink + ' ' + classes.navCategoryLink + '" data-flip-category="' + category + '">' + category + '</a>')
                                        .data('category', category)
                                        .data('index', i);
    
                                navCategories[category] = $('<ul class="' + classes.navChild + '" />');
    
                                _navLinks = _navLinks.add(categoryLink);
    
                                categoryItem
                                    .append(categoryLink, navCategories[category])
                                    .appendTo(_nav);
                            }
    
                            navCategories[category].append(navLink);
                        } else {
                            _nav.append(navLink);
                        }
    
                        navLink.wrap('<li class="' + classes.navItem + '">');
    
                    });
    
                    _nav.on('click', 'a', function(e) {
                        var index = $(this).data('index');
                        if ( index >= 0 ) {
                            jump(index);
                            e.preventDefault();
                        }
                    });
    
                    if ( settings.nav === 'after' ) { self.append(_nav); }
                    else { self.prepend(_nav); }
    
                    _navItems = _nav.find('.' + classes.navItem);
                }
    
                function updateNav() {
                    if ( settings.nav ) {
    
                        var category = _currentItem.data('flip-category');
    
                        _navItems.removeClass(classes.navCurrent);
    
                        _navLinks
                            .filter(function() {
                                return ($(this).data('index') === _currentIndex || (category && $(this).data('category') === category));
                            })
                            .parent()
                            .addClass(classes.navCurrent);
    
                    }
                }
    
                function noTransition() {
                    self.css('transition', 'none');
                    _container.css('transition', 'none');
                    _items.css('transition', 'none');
                }
    
                function resetTransition() {
                    self.css('transition', '');
                    _container.css('transition', '');
                    _items.css('transition', '');
                }
    
                function calculateBiggestItemHeight() {
                    var biggestHeight = 0,
                        itemHeight;
    
                    _items.each(function() {
                        itemHeight = $(this).height();
                        if ( itemHeight > biggestHeight ) { biggestHeight = itemHeight; }
                    });
                    return biggestHeight;
                }
    
                function resize(skipTransition) {
                    if ( skipTransition ) { noTransition(); }
    
                    _containerWidth = _container.width();
                    _container.height(calculateBiggestItemHeight());
    
                    _items.each(function(i) {
                        var item = $(this),
                            width,
                            left;
    
                        item.attr('class', function(i, c) {
                            return c && c.replace(classRemover, '').replace(whiteSpaceRemover, ' ');
                        });
    
                        width = item.outerWidth();
    
                        if ( settings.spacing !== 0 ) {
                            item.css('margin-right', ( width * settings.spacing ) + 'px');
                        }
    
                        left = item.position().left;
                        _itemOffsets[i] = -1 * ((left + (width / 2)) - (_containerWidth / 2));
    
                        if ( i === _items.length - 1 ) {
                            center();
                            if ( skipTransition ) { setTimeout(resetTransition, 1); }
                        }
                    });
                }
    
                function center() {
                    var total = _items.length,
                        loopCount = ( settings.loop !== true && settings.loop > 0 ? settings.loop : false ),
                        item, newClass, zIndex, past, offset;
    
                    if ( _currentIndex >= 0 ) {
    
                        _items.each(function(i) {
                            item = $(this);
                            newClass = ' ';
    
                            if ( i === _currentIndex ) {
                                newClass += classes.itemCurrent;
                                zIndex = (total + 2);
                            } else {
                                past = ( i < _currentIndex ? true : false );
                                offset = ( past ? _currentIndex - i : i - _currentIndex );
    
                                if ( loopCount ) {
                                    if ( _currentIndex <= loopCount && i > _currentIndex + loopCount ) {
                                        past = true;
                                        offset = (total + _currentIndex) - i;
                                    } else if ( _currentIndex >= total - loopCount && i < _currentIndex - loopCount ) {
                                        past = false;
                                        offset = (total - _currentIndex) + i;
                                    }
                                }
    
                                newClass += (past ?
                                    classes.itemPast + ' ' + classes.itemPast + '-' + offset :
                                    classes.itemFuture + ' ' + classes.itemFuture + '-' + offset
                                );
    
                                zIndex = total - offset;
                            }
    
                            item
                                .css('z-index', zIndex * 2)
                                .attr('class', function(i, c) {
                                    return c && c.replace(classRemover, '').replace(whiteSpaceRemover, ' ') + newClass;
                                });
                        });
    
                        if ( !_containerWidth || _itemOffsets[_currentIndex] === undefined ) { resize(true); }
    
                        if ( transformSupport ) {
                            _container.css('transform', 'translateX(' + _itemOffsets[_currentIndex] + 'px)');
                        } else {
                            _container.css('left', _itemOffsets[_currentIndex] + 'px' );
                        }
                    }
    
                    updateNav();
                }
    
                function jump(to) {
                    var _previous = _currentIndex;
    
                    if ( _items.length <= 1 ) { return; }
    
                    if ( to === 'prev' ) {
                        if ( _currentIndex > 0 ) { _currentIndex--; }
                        else if ( settings.loop ) { _currentIndex = _items.length - 1; }
                    } else if ( to === 'next' ) {
                        if ( _currentIndex < _items.length - 1 ) { _currentIndex++; }
                        else if ( settings.loop ) { _currentIndex = 0; }
                    } else if ( typeof to === 'number' ) { _currentIndex = to;
                    } else if ( to !== undefined ) {
                        // if object is sent, get its index
                        _currentIndex = _items.index(to);
                    }
    
                    _currentItem = _items.eq(_currentIndex);
    
                    if ( _currentIndex !== _previous && settings.onItemSwitch ) {
                        settings.onItemSwitch.call(self, _items[_currentIndex], _items[_previous]);
                    }
    
                    center();
    
                    return self;
                }
    
                function play(interval) {
                    settings.autoplay = interval || settings.autoplay;
    
                    clearInterval(_playing);
    
                    _playing = setInterval(function() {
                        var prev = _currentIndex;
                        jump('next');
                        if ( prev === _currentIndex && !settings.loop ) { clearInterval(_playing); }
                    }, settings.autoplay);
    
                    return self;
                }
    
                function pause() {
                    clearInterval(_playing);
                    if ( settings.autoplay ) { _playing = -1; }
    
                    return self;
                }
    
                function show() {
                    resize(true);
                    self.hide()
                        .css('visibility', '')
                        .addClass(classes.active)
                        .fadeIn(settings.fadeIn);
                }
    
                function index() {
    
                    _container = self.find(settings.itemContainer).addClass(classes.container);
    
                    _items = _container.find(settings.itemSelector);
    
                    if ( _items.length <= 1 ) { return; }
    
                    _items
                        .addClass(classes.item)
                        // Wrap inner content
                        .each(function() {
                            var item = $(this);
                            if ( !item.children('.' + classes.itemContent ).length) {
                                item.wrapInner('<div class="' + classes.itemContent + '" />');
                            }
                        });
    
                    // Navigate directly to an item by clicking
                    if ( settings.click ) {
                        _items.on('click.flipster touchend.flipster', function(e) {
                            if ( !_startDrag ) {
                                if ( !$(this).hasClass(classes.itemCurrent) ) { e.preventDefault(); }
                                jump(this);
                            }
                        });
                    }
    
                    // Insert navigation if enabled.
                    buildButtons();
                    buildNav();
    
                    if ( _currentIndex >= 0 ) { jump(_currentIndex); }
    
                    return self;
                }
    
                function keyboardEvents(elem) {
                    if ( settings.keyboard ) {
                        elem[0].tabIndex = 0;
                        elem.on('keydown.flipster', throttle(function(e) {
                            var code = e.which;
                            if ( code === 37 || code === 39 ) {
                                jump( code === 37 ? 'prev' : 'next' );
                                e.preventDefault();
                            }
                        }, 250, true));
                    }
                }
    
                function wheelEvents(elem) {
                    if ( settings.scrollwheel ) {
                        var _wheelInside = false,
                            _actionThrottle = 0,
                            _throttleTimeout = 0,
                            _delta = 0,
                            _dir, _lastDir;
    
                        elem
                            .on('mousewheel.flipster wheel.flipster', function() { _wheelInside = true; })
                            .on('mousewheel.flipster wheel.flipster', throttle(function(e) {
    
                                // Reset after a period without scrolling.
                                clearTimeout(_throttleTimeout);
                                _throttleTimeout = setTimeout(function() {
                                    _actionThrottle = 0;
                                    _delta = 0;
                                }, 300);
    
                                e = e.originalEvent;
    
                                // Add to delta (+=) so that continuous small events can still get past the speed limit, and quick direction reversals get cancelled out
                                _delta += (e.wheelDelta || (e.deltaY + e.deltaX) * -1); // Invert numbers for Firefox
    
                                // Don't trigger unless the scroll is decent speed.
                                if ( Math.abs(_delta) < 25 ) { return; }
    
                                _actionThrottle++;
    
                                _dir = (_delta > 0 ? 'prev' : 'next');
    
                                // Reset throttle if direction changed.
                                if ( _lastDir !== _dir ) { _actionThrottle = 0; }
                                _lastDir = _dir;
    
                                // Regular scroll wheels trigger less events, so they don't need to be throttled. Trackpads trigger many events (inertia), so only trigger jump every three times to slow things down.
                                if ( _actionThrottle < 6 || _actionThrottle % 3 === 0 ) { jump(_dir); }
    
                                _delta = 0;
    
                            }, 50));
    
                        // Disable mousewheel on window if event began in elem.
                        $window.on('mousewheel.flipster wheel.flipster', function(e) {
                            if ( _wheelInside ) {
                                e.preventDefault();
                                _wheelInside = false;
                            }
                        });
                    }
                }
    
                function touchEvents(elem) {
                    if ( settings.touch ) {
                        var _startDragY = false,
                            _touchJump = throttle(jump, 300),
                            x, y, offsetY, offsetX;
    
                        elem.on({
                            'touchstart.flipster': function(e) {
                                e = e.originalEvent;
                                _startDrag = (e.touches ? e.touches[0].clientX : e.clientX);
                                _startDragY = (e.touches ? e.touches[0].clientY : e.clientY);
                                //e.preventDefault();
                            },
    
                            'touchmove.flipster': throttle(function(e) {
                                if ( _startDrag !== false ) {
                                    e = e.originalEvent;
    
                                    x = (e.touches ? e.touches[0].clientX : e.clientX);
                                    y = (e.touches ? e.touches[0].clientY : e.clientY);
                                    offsetY = y - _startDragY;
                                    offsetX = x - _startDrag;
    
                                    if ( Math.abs(offsetY) < 100 && Math.abs(offsetX) >= 30 ) {
                                        _touchJump((offsetX < 0 ? 'next' : 'prev'));
                                        _startDrag = x;
                                        e.preventDefault();
                                    }
    
                                }
                            }, 100),
    
                            'touchend.flipster touchcancel.flipster ': function() { _startDrag = false; }
                        });
                    }
                }
    
                function init() {
    
                    var style;
    
                    self.css('visibility', 'hidden');
    
                    index();
    
                    if ( _items.length <= 1 ) {
                        self.css('visibility', '');
                        return;
                    }
    
                    style = (settings.style ? 'flipster--' + settings.style.split(' ').join(' flipster--') : false);
    
                    self.addClass([
                        classes.main,
                        (transformSupport ? 'flipster--transform' : ' flipster--no-transform'),
                        style, // 'flipster--'+settings.style : '' ),
                        (settings.click ? 'flipster--click' : '')
                    ].join(' '));
    
                    // Set the starting item
                    if ( settings.start ) {
                        // Find the middle item if start = center
                        _currentIndex = ( settings.start === 'center' ? Math.floor(_items.length / 2) : settings.start );
                    }
    
                    jump(_currentIndex);
    
                    var images = self.find('img');
    
                    if ( images.length ) {
                        var imagesLoaded = 0;
    
                        // Resize after all images have loaded.
                        images.on('load', function() {
                            imagesLoaded++;
                            if ( imagesLoaded >= images.length ) { show(); }
                        });
    
                        // Fallback to show Flipster while images load in case it takes a while.
                        setTimeout(show, 750);
                    } else {
                        show();
                    }
    
                    // Attach event bindings.
                    $window.on('resize.flipster', throttle(resize, 400));
    
                    if ( settings.autoplay ) { play(); }
    
                    if ( settings.pauseOnHover ) {
                        _container
                            .on('mouseenter.flipster', pause)
                            .on('mouseleave.flipster', function() {
                                if ( _playing === -1 ) { play(); }
                            });
                    }
    
                    keyboardEvents(self);
                    wheelEvents(_container);
                    touchEvents(_container);
                }
    
                // public methods
                methods = {
                    jump: jump,
                    next: function() { return jump('next'); },
                    prev: function() { return jump('prev'); },
                    play: play,
                    pause: pause,
                    index: index
                };
                self.data('methods', methods);
    
                // Initialize if flipster is not already active.
                if ( !self.hasClass(classes.active) ) { init(); }
            });
        };
    })(jQuery, window);
    
    
    
    var flipContainer = $('.flipster'),
    flipItemContainer = flipContainer.find('.flip-items'),
    flipItem = flipContainer.find('li');

flipContainer.flipster({
    itemContainer: flipItemContainer,
    itemSelector: flipItem,
    loop: 2,
    start: 0,
    style: 'infinite-carousel',
    spacing: 0,
    scrollwheel: false,
    //nav: 'after',
    buttons: false,
    onItemSwitch: function (currentItem, previousItem) {
        var description = $(currentItem).data('description');
        var strippedDescription = description.replace(/<[^>]+>/g, '');
        
        $('#description').html(description);
    }
});


    // 초기 설명 표시
var initialItem = flipContainer.flipster('current');
var initialDescription = $(initialItem).data('description');
var strippedInitialDescription = initialDescription.replace(/<[^>]+>/g, '');
$('#description').text(strippedInitialDescription);

    </script>
</body>

</html>