<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>BudgetBuddy | 가계부 달력</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
        <link type="image/png" sizes="16x16" rel="icon" href="/account/asset/images/icons8-돈-상자-16.png">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <!-- Libraries Stylesheet -->
</head>
<style>

   #periodcheck{
        display: flex;
        justify-content: center;
        margin: auto;
    }
    #periodcheck button{
        margin: 5px;
    }

    #monthgoal{
        width: 300px;
        height: 100px;
        background-color: aqua;
        margin-right: 30px;
        align-items: center;
        justify-content: center;
        display: flex;
    }
    #currentsituation{
        width: 300px;
        height: 100px;
        background-color: black;
        align-items: center;
        justify-content: center;
        display: flex;
    }
    }
      /* ---calendar css start */
      #onerow {
        display: flex;
        justify-content: center; 
        align-items: center; 
        width: 100%; 
        margin: auto; 
      }

    #onrowlabel {
        width: 50px; 
        height: 50px; 
        display: flex;
        justify-content: center; 
        align-items: center; 
        margin-right: 10px; 
        text-align: center; 
    }

#onerowinput {
    display: flex;
    align-items: center; 
    width: 100%; 
}

#eventModalSelect, #eventModalIoc {
    flex: 1; 
}

#onerowinput #eventModalSelect{
    width: 50px;
}
/* .input-style-form, .input-style-form {
    margin: 0 5px; 
} */
.selectSize{
    width: 100px ;
}

   .abovestat{
        display: flex;
        align-items: center;
    }

    .abovestat div{
        margin-left: 10px;
        margin-bottom: 10px;
    }

    #spendstat{
        margin-top: 10px;
    }

    #aboverow {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between !important;
    width: 100%; 
    }
    
    .right-icon{
        width: auto;
        height: 100%;
    }



/* #spendstat :nth-child(2){
    color: #fe7e70;
}

#incomestat :nth-child(2){
    color: #366ECD;
} */

#bottomrow{
    display: flex;
    justify-content: center;
    align-items: flex-end;
    padding-left: 20px;
    width: 40%;
    flex-direction: column;
}

.right-icon i {
    font-size: 24px;  
    width: 30px;      
    height: 30px; 
    margin: 10px;    
}

#wishlist {
    padding: 20px;
    background: #ffffff;
    border-radius: 8px;
   	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05); 
    margin: 10px;
    border: 1px solid #ccc;
    width: 100%;
    
}

#wishlist h3 {
    color: #333;
}

#wishlist form {
    margin-bottom: 10px;
}

#wishlist input[type="text"] {
    padding: 8px;
    margin-right: 4px;
    border: 1px solid #ccc;
    border-radius: 4px;
    width: 70%;
}

#newitembutton{
    width: 30%;
}


#wishListItems li {
    list-style: none;
    margin-top: 8px;
    background: white;
    padding: 8px;
    border: 1px solid #ddd;
    border-radius: 4px;
}

#bottomrow{
    display: flex;
    justify-content: center;
    align-items: baseline;
    padding-left: 20px;
}

#wishlist{
    width: 100%;
}

#wishlistrow1{
    display: flex;
    justify-content: space-between;
    flex-direction: row;
}

#wishlistrow1 h3{
    margin-right: 10px;
}

#addWishItemtitle{
    display: flex;
    justify-content: center;
}

#transcontent {
    border: 1px solid #ccc;
    width: 100%;
    display: flex;
    margin: 10px 0;
    background-color: #ffffff;
    box-shadow: 0 2px 4px rgba(0,0,0,0.05);
    border-radius: 8px;
    justify-content: center;
    align-items: center;
    
}
#thismonthstat {
    flex-grow: 1; 
    font-weight: bold;
    padding: 20px;
    background: #ffffff;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
    border: 1px solid #ccc;
    width: 100%;
    margin:10px;
}

  .abovestat{
        display: flex;
        align-items: center;
    }

    .abovestat div{
    	margin: 10px;
    }

.transin {
    flex: 1;
    padding: 10px;
    display: flex;
    align-items: center;
}

.frontback{
    margin: 10px;
}

#listdelbutton :hover{
    cursor: pointer;
}

#wishlistrow2{
    display: flex;
    justify-content: space-between;
    margin-top: 15px;
}

.categorylist{
    border: 1px solid black;
    width: 50%;
    height: 30px;
    margin: 5px;
}

#categorymodalbody{
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
}

.categorylistselector{
    display: flex;
    border: 1px solid #CCC;
    background-color: #F3f6f9;
    width: auto;
    margin: 5px;
    justify-content: center;
    padding: 5px;
    border-radius: 5px;
}

.categorylistselector:hover{
    cursor: pointer;
    box-shadow: 0 4px 4px rgba(0,0,0,0.1);
}

#totalbody{
	background-color: #FFFFFF 
}    

#middlebottom {
    display: flex;  /* Use flexbox for layout */
    justify-content: space-between; /* Space between the main elements */
    align-items: start; /* Align items at the start of the container */
    width: 100%;
}
#calendar{
	width: 100%;
}



#aboverowright{
	display: flex;
}

.fc-button-primary{

}

/* FullCalendar Button Color Customization */
.fc-button {
    background-color: #ADA0DE !important;
    border: 1px solid #ADA0DE !important;
    border-radius: 0.25em !important;
    display: inline-block;
    font-size: 1em;
    font-weight: 400;
    line-height: 1.5;
    padding: 0.4em 0.65em;
    text-align: center;
    user-select: none;
    vertical-align: middle;
    color: #fff;   /* Green border */
}

.fc .fc-button-group > .fc-button {
	margin: 5px;
}

.fc-button:hover {
    background-color: #45A049; /* Darker green background on hover */
}


    

    <%@include file="/WEB-INF/views/inc/asset.jsp"%>
      

</style>

<body id="totalbody">
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
        <%@include file="/WEB-INF/views/inc/account-sidebar.jsp"%>
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
        <div class="content-total-style">
            <div id="aboverow" class="content-header">
            <div class="content-title-style">
						<h3>가계부 달력</h3>
					</div>
					<div id="aboverowright">
			      		<form method = "GET" id="accountSearchForm" action="/account/account/list.do">
			                <div class="right-icon" id="searchicon"><i class="fa-solid fa-magnifying-glass"></i></div> 
			                <div id="searchbar" class="account-search-box-container">
			                	<input type="text" name="word" value="${map.word}" placeholder="내용 or 사용처" class="input-style-form">
			                	<input type="submit" value="검색" class="button purple-btn">
			                </div>
			            </form>    
	                	<div class="right-icon" id="categoryselector"><i class="fa-solid fa-list-check"></i></div> 
                	</div>
            </div>
            <div id="middlebottom">
            <div id='calendar'></div>
            <div id="bottomrow">
                <div id="thismonthstat">
          			<div id="monthheader">
          				<h4 style="display: flex;"><div id="monthindicate"></div>월</h4>
          			</div>
                    <div class="abovestat" id="spendstat">
                        <span>이번달 지출</span>
                        <div id="totalNegative">$0</div>
                    </div>
                    <div class="abovestat" id="incomestat">
                        <span>이번달 수입</span>
                        <div id="totalPositive">$0</div>
                    </div>
                    
                </div>
                <div id="wishlist">
                    <div id="wishlistrow1">
                        <h4>Wish List</h4>
                        <div id="addWishItemtitle">
                            <button id="addrightnow" class="purple-btn button">추가하기</button>
                        </div>
                    </div>
                    <div id="wishlistrow2">
                        <input type="text" id="newItemInput" placeholder="구매 위시 항목" style="display: none;" class="input-style-form">
                        <button id="newItemButton" style="display: none" class="purple-btn button">등록</button>
                    </div>
                    <div id="wishListItems">
                        
                    </div>
                </div>
            </div>
        <!-- Back to Top -->
        </div>
        </div>
    </div>

   <div class="modal fade" id="eventProduceModal" tabindex="-1"
    aria-labelledby="eventProduceModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modalBackground">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="eventProduceModalLabel">가계부 추가</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
                </div>
            
                <div class="modal-body">
                    <form>
                        <div class="mb-3">
                            <div class="container">
                                <div id="color-selector">
                                </div>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="eventModalStart" class="col-form-label">날짜</label> <input type="datetime-local" id="eventModalStart"
                                class="input-style-form" placeholder="datetime-local input">
                        </div>
                        <div class="mb-3">
                            <label for="eventModalTitle" class="col-form-label">내용</label> <textarea
                                type="text" class="input-style-form" id="eventModalcontent"></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="eventModalTitle" class="col-form-label">사용처</label> <input
                                type="text" class="input-style-form" id="eventModaluseloc">
                        </div>
                        <div class="mb-3">
                            <label for="eventModalSelect" class="col-form-label">카테고리</label>
                            <select class="input-style-form modalselectcategory" aria-label="Default select example"
                                id="eventModalSelect">
                                <option selected>카테고리</option>
                                <option value="1">개인일정</option>
                                <option value="2">공유일정</option>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="eventModalSelect" class="col-form-label">지불 방식</label>
                            <select class="input-style-form modalmethodofpayment" aria-label="Default select example"
                                id="eventModalSelect">
                                <option selected>지불 방식</option>
                                <option value="1">카드</option>
                                <option value="2">현금</option>
                            </select>
                        </div>
                        <div class="mb-3" id="onerow">
                            <div for="eventModalEnd" class="col-form-label" id="onrowlabel">금액</div>
                            <div id="onerowinput">
                                <select class="input-style-form selectSize modalincreasedecrease" aria-label="Default select example"
                                    id="eventModalSelect">
                                    <option selected>+/-</option>
                                    <option value="1">+</option>
                                    <option value="2">-</option>
                                </select>
                                <input type="number" class="input-style-form" id="eventModalIoc">
                                <input type="checkbox" id="fixedexpense">
                            </div>
                        </div>
                        <div class="mb-3" id="fixeddate">

                            <label for="eventModalStart" class="col-form-label">고정 지출 날짜</label> 
                             <textarea type="text" class="form-control fixedmemo" id="eventModalMemo"></textarea>
                            <select class="form-select selectSize modalfixedperiod " aria-label="Default select example"
                                    id="eventModalSelect">
                                    <option selected>기간</option>
                                    <option value="1">월</option>
                                    <option value="2">분기</option>
                                    <option value="3">년</option>
                             </select>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="button gray-btn submit-btn-style" data-bs-dismiss="modal">취소</button>
					<button type="button" class="button dark-black-btn submit-btn-style" id="deleteEventBtn">삭제</button>
					<button type="button" class="button purple-btn submit-btn-style" id="editEventBtn">수정</button>
					<button type="button" class="btn purple-btn submit-btn-style" id="produceEventBtn">생성</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="categorymodal" tabindex="-1"
    aria-labelledby="eventProduceModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modalBackground">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="eventProduceModalLabel">카테고리 선택</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
                </div>
                <div class="modal-body" id="categorymodalbody">


                </div>
                <div class="modal-footer">
                    <button type="button" class="button gray-btn submit-btn-style" data-bs-dismiss="modal">취소</button>
                    <button type="button" class="button purple-btn submit-btn-style" id="btnEventProduce">완료</button>
                </div>
            </div>
        </div>
    </div>
</div>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.1/chart.min.js"></script><script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>
    <link href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/5.11.0/main.min.css' rel='stylesheet' />
    <script src='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/5.11.0/main.min.js'></script>
   
    <!-- Template Javascript -->
    <script src="${pageContext.request.contextPath}/asset/css/temp/js/main.js"></script>
    <script>
    var delRequest = null;
	var addRequest = null;
	var editRequest = null;
   	var categories = [];
    var colors = {};
    
    var editbutton = document.getElementById('editEventBtn');
    var delbutton = document.getElementById('deleteEventBtn');
    var procbutton = document.getElementById('produceEventBtn');
    <c:forEach items="${cList}" var = "dto">
	categories.push('${dto.acName}');
	</c:forEach>
   console.log(categories); 
   
   
   var cardlist = [];
   	<c:forEach items="${cardlist}" var = "dto">
		cardlist.push('${dto.paymentMethod}, ${dto.paymentMethod}:${dto.alias}:${dto.cardNumber}');
	</c:forEach>
	
	// 미리 정의된 색상 팔레트
	const colorPalette = [
		'#F3FAFF',
		'#36A2EB', '#FF6384', '#4BC0C0', '#FC9D3F', '#9966FF', '#FFCD56', '#C9CBCF', '#F9F871', '#A0F48B', '#A3459B',
	    '#E17AA7', '#EEE8A9', '#265E58', '#F47558', '#D25F9C', '#9B61A3', '#00524A', '#655E96', '#3E567A', '#2F4858',
	    '#DD6C41', '#A57A11', '#647E17', '#007A3E', '#007165', '#96525D', '#FFE3E9', '#BFA5A8', '#53D0B9', '#6FDEAA',
	    '#97EA96', '#C6F381', '#F6746C', '#CA638D', '#896095', '#4D587F', '#C7B1E6', '#FAEAFF', '#65BAA9', '#FFCA57'
	];
	
	// colors 객체에 각 카테고리에 고유한 색상 할당
	categories.forEach((categoryName, index) => {
	    colors[categoryName] = colorPalette[index % colorPalette.length];
	});
	/* console.log(colors.value('주거')); */
	 var transactions = [];
    let transactionItem = {};
	
	<c:forEach items="${eventsev}" var="dto">
    	transactionItem  = {
	        date: '${dto.start}',
	        category: '${dto.category}',
	        where: '${dto.loc}',
	        content: '${dto.content}',
	        amount: '${dto.amount}',
	        amountIndicator: '${dto.amountIndicator == '1' ? '+' : '-'}', /* 1이 입급, 2가 출금 */
	    };
	    	    
	    transactions.push(transactionItem);
	</c:forEach>
	console.log(transactions);

	
	 function getCurrentMonthYear() {
        const now = new Date();
        const headerMonth = (now.getMonth() + 1).toString();
        const currentMonth = (now.getMonth() + 1).toString().padStart(2, '0'); // getMonth returns month from 0 (January) to 11 (December)
        const currentYear = now.getFullYear().toString();
        return { currentMonth, currentYear,headerMonth };
    }
	
	function calculateAndDisplayTotals(transactions) {
        const { currentMonth, currentYear, headerMonth } = getCurrentMonthYear();
        let totalPositive = 0;
        let totalNegative = 0;
        const lastTwoDigitsOfYear = currentYear.substring(2,4);
        console.log("Current Month:", currentMonth);
        console.log("Current Year (last two digits):", lastTwoDigitsOfYear);
		console.log(headerMonth);
        transactions.forEach(transaction => {
            var transactionDate = transaction.date;
            console.log(transactionDate);
            var transactionMonth = transactionDate.substring(5,7);
            var transactionYear = transactionDate.substring(2,4);
            console.log(transactionMonth);
            console.log(transactionYear);
            // Only process transactions from the current month and year
            if (transactionMonth === currentMonth && transactionYear === lastTwoDigitsOfYear) {
                console.log('here')
                let amount = parseFloat(transaction.amount.replace(/,/g, '')); // Convert string amount to number
                if (transaction.amountIndicator === '+') {
                    totalPositive += amount; // Sum positive amounts
                } else if (transaction.amountIndicator === '-') {
                    totalNegative += amount; // Sum negative amounts
                }
            }
        });
	
        console.log(totalPositive);
        console.log(totalNegative);
        
        let formattedPositive = (totalPositive > 0 ? '+'+totalPositive.toLocaleString()+'원' : totalPositive.toLocaleString());
        let formattedNegative = (totalNegative < 0 ? totalNegative.toLocaleString() : '-'+totalNegative.toLocaleString()+'원');
        document.getElementById('monthindicate').innerHTML = headerMonth;
        document.getElementById('totalPositive').innerHTML = formattedPositive;
        document.getElementById('totalNegative').innerHTML = formattedNegative;
        // Update the DOM with the calculated totals
    }

    // Example usage:
    calculateAndDisplayTotals(transactions);
	
	
	function populatePaymentMethodSelect() {
        paymentMethodSelect.innerHTML = ''; // Clear existing options
        cardlist.forEach(function(card) {
            var parts = card.split(',');
            var option = document.createElement('option');
            option.value = parts[0]; // Assuming the first part is the value
            option.textContent = parts[1]; // Assuming the second part is the user-friendly name
            paymentMethodSelect.appendChild(option);
        });
    }
	
	
    function openEventModal() {
        var modal = new bootstrap.Modal(document.getElementById("eventProduceModal"));
        // Clear previous data in the modal or set defaults
        document.getElementById('eventModalStartDate').value = new Date().toISOString().slice(0, 16); // Set to current date and time
        document.getElementById('eventModalContent').value = '';
        document.getElementById('eventModalUsage').value = ''; // Corrected for unique ID
        document.getElementById('eventModalCategory').selectedIndex = 0; // Resets the category dropdown, corrected ID
        document.getElementById('eventModalPaymentMethod').selectedIndex = 0; // Resets the payment method dropdown, corrected ID
        modal.show();
    }
    //모달 소환시 입력 무 (시작)
    function clearModalInputs() {
        document.getElementById('eventModalcontent').value = '';
        document.getElementById('eventModalStart').value = '';
        if (document.getElementsByClassName('modalselectcategory').length > 0) {
            document.getElementsByClassName('modalselectcategory')[0].selectedIndex = 0;
        }
        if (document.getElementsByClassName('modalmethodofpayment').length > 0) {
            document.getElementsByClassName('modalmethodofpayment')[0].selectedIndex = 0;
        }
        if (document.getElementsByClassName('modalincreasedecrease').length > 0) {
            document.getElementsByClassName('modalincreasedecrease')[0].selectedIndex = 0;
        }
        document.getElementById('eventModaluseloc').value = '';
        document.getElementById('eventModalIoc').value = '';
        document.getElementById('fixedexpense').checked = false; 
        
        if (document.getElementsByClassName('modalfixedperiod').length > 0) {
            document.getElementsByClassName('modalfixedperiod')[0].selectedIndex = 0;
        }
    }
    //모달 소환시 입력 무 (끝)


            
    document.addEventListener('DOMContentLoaded', function() {
        
        
        var calendarEl = document.getElementById('calendar');
        var checkbox = document.getElementById('fixedexpense');
        var fixedDateDiv = document.getElementById('fixeddate');
        var eventProduceModal = document.getElementById('eventProduceModal');
        var addwishlistnow = document.getElementById('addrightnow');
        var categoryselector = document.getElementById('categoryselector')
        var categorymodalbody = document.getElementById('categorymodalbody')
        var categorySelector = document.getElementById('eventModalSelect'); 
        var paymentMethodSelect = document.querySelector('.modalmethodofpayment');
        
        
        function populatePaymentMethodSelect() {
            // Assuming we want to keep the existing options and append new ones, start after the default options
            // Remove all dynamically added options first, assuming they have a class 'dynamic-option'
            var existingOptions = paymentMethodSelect.querySelectorAll('.dynamic-option');
            existingOptions.forEach(function(option) {
                option.remove();
            });

            // Append new options from cardlist
            cardlist.forEach(function(card) {
                var parts = card.split(',');
                var option = document.createElement('option');
                option.classList.add('dynamic-option'); // Mark it as dynamically added for future updates
                option.value = parts[1]; // Assuming the first part is the value
                option.textContent = parts[1]; // Assuming the second part is the user-friendly name
                paymentMethodSelect.appendChild(option);
            });
        }
        
        
        
        // 카테고리 선택 시작
        

    function populateCategorySelector() {
            categorySelector.innerHTML = ''; // Clear existing options
            categories.forEach(function(category) {
                var option = document.createElement('option');
                option.value = category;
                option.textContent = category;
                categorySelector.appendChild(option);
            });
        }

        populateCategorySelector();

        console.log(categories)
        categoryselector.addEventListener('click', function() {
            var modal = new bootstrap.Modal(document.getElementById("categorymodal"));

            if (categorymodalbody.children.length <= 0) {
                categories.forEach(category => {
                    var cate = document.createElement('button');
//                     var cate = document.createElement('div');
                    console.log(category)
                    cate.className = 'categorylistselector light-purple-btn button';
                    cate.innerHTML = '<div>' + category + '</div>';
                    categorymodalbody.appendChild(cate);
                });
            }


            modal.show();
        })
        //카테고리 선택 끝
	 	// 검색 기능
	    var searchicon = document.getElementById('searchicon');
	    var searchbar = document.getElementById('searchbar');
	   
	    searchicon.onclick = function() {
	        if (searchbar.style.display === 'none') {
	            searchbar.style.display = 'flex';
	            searchbar.focus();
	        } else {
	            searchbar.style.display = 'none';
	        }
	    };
	    //검색 기능 끝
        

    // 고정 지출 시작
    eventProduceModal.addEventListener('show.bs.modal', function () {
        checkbox.checked = false; // Uncheck the checkbox
        fixedDateDiv.style.display = 'none'; // Hide the date input
        populatePaymentMethodSelect();

    });

        checkbox.addEventListener('change', function() {
            if (checkbox.checked) {
                fixedDateDiv.style.display = 'block'; // Show the fixed date input
            } else {
                fixedDateDiv.style.display = 'hidden'; // Hide the fixed date input
            }
        });
    //고정 지출 끝

    //항목 추가 시작
    document.getElementById('produceEventBtn').addEventListener('click', function() {
        var content = document.getElementById('eventModalcontent').value;
        var start = document.getElementById('eventModalStart').value;
        var category = document.getElementsByClassName('modalselectcategory')[0].value;
        var useLocation = document.getElementById('eventModaluseloc').value;
        var paymentMethod = document.getElementsByClassName('modalmethodofpayment')[0].value;
        var amountindicator = document.getElementsByClassName('modalincreasedecrease')[0].value;
        var amount = document.getElementById('eventModalIoc').value;
        var isFixedExpense = document.getElementById('fixedexpense').checked;
        var period;  
		var memo;
    
		
		if (isFixedExpense) {
        	console.log('checked');
	         period = document.getElementsByClassName('modalfixedperiod')[0].value;
	         memo = document.getElementsByClassName('fixedmemo')[0].value;
	         
	         if(period==='기간' || !memo){
	        	 alert('모든 필수 필드를 입력해주세요.');
	        	 return;
	         }
        } else {
             period = 0;
        	 memo = 0;
        }
        
       	
       	
        console.log(isFixedExpense);
        editbutton.style.display='none';
        delbutton.style.display='none';
        /* var isFixedperiod = document.getElementById('fixedexpense').checked;  */
        
        // Validate the inputs
        if (!content || !start || !category || !amount ) {
            alert('모든 필수 필드를 입력해주세요.'); // Alert if any required field is missing
            return;
        }
        
        console.log(content, start, category, useLocation, paymentMethod,amountindicator, amount, isFixedExpense, memo, period);

        
         let sign = amountindicator === '1' ? '+' : '-';
         // Check if the amount is greater than 10000 and adjust accordingly
         let displayAmount;
         if (parseFloat(amount) > 10000) {
             // Round up and remove the last 4 digits
             displayAmount = Math.ceil(amount / 10000) * 10000;
             displayAmount = displayAmount / 10000;
             displayAmount = displayAmount +'만원';// Now this represents the '0000' truncated
         } else {
             displayAmount = amount;
         };
        
        // Create a new event object
        var event = {
            title: category + sign + displayAmount,
            start: start,
            allDay: true,
            color: colors[category], 
            extendedProps: {
                useLocation: useLocation,
                content: content,
                category: category,
                paymentMethod: paymentMethod,
                amount: amount,
                amountindicator: amountindicator,
                isFixedExpense: isFixedExpense, 
                fixedExpensePeriod: period,
                fixedMemo: memo
            }
        };

        // Add the event to the calendar
        calendar.addEvent(event);
        
        if (addRequest) {
			addRequest.abort();
		}
        
        addRequest = $.ajax({
        	type: 'post',
        	url: '/account/account/calendar.do',
        	data:{
        		start: start,
        		useLocation: useLocation,
        		content: content,
        		category: categories.indexOf(category),
        		paymentMethod: paymentMethod,
        		amount: amount,
        		amountindicator: amountindicator,
        		isFixedExpense: isFixedExpense,
        		isFixedperiod: period,
        		fixedMemo: memo
        	}
        })
        

        // Optionally clear the modal inputs
        document.getElementById('eventModalcontent').value = '';
        document.getElementById('eventModalStart').value = '';
        Array.from(document.querySelectorAll('#eventProduceModal select')).forEach(select => select.selectedIndex = 0);
        document.getElementById('eventModaluseloc').value = '';
        document.getElementById('eventModalIoc').value = '';
        document.getElementById('fixedexpense').checked = false;

        // Hide the modal, assuming using Bootstrap's modal
        $('#eventProduceModal').modal('hide');

        // Log or handle the data as needed, e.g., send it to a server
        console.log('Event data:', event);
        // Here you can also make an AJAX call to send the data to the server
    });

    //항목 추가 끝
	var currentEventId = null;
    
	
    
     calendar = new FullCalendar.Calendar(calendarEl, {
            timeZone:'UTC',
            editable: true,
            eventSources: [
                $.ajax({
         			type: 'get',
         			url: '/account/account/calendarjson.do',
         			dataType: 'json',
         			success: function(result){
         				result.forEach(obj =>{
         					let sign = obj.amountIndicator === '1' ? '+' : '-';
         	                // Check if the amount is greater than 10000 and adjust accordingly
         	                let displayAmount;
         	                if (parseFloat(obj.amount) > 10000) {
         	                    // Round up and remove the last 4 digits
         	                    displayAmount = Math.ceil(obj.amount / 10000) * 10000;
         	                    displayAmount = displayAmount / 10000;
         	                    displayAmount = displayAmount +'만원';// Now this represents the '0000' truncated
         	                } else {
         	                    displayAmount = obj.amount+'원';
         	                };
         	                
         					
         					calendar.addEvent({
         						title:  sign + displayAmount,
         						allDay: true,
         						start: obj.start,
         						color: colors[obj.category], 
         						extendedProps: {
      			   					useLocation: obj.loc,
      			   					content: obj.content,
      			   					amount: obj.amount,
      			   					amountindicator: obj.amountIndicator,
      			   					paymentMethod : (obj.paymentMethod+':'+obj.aliasname+':'+obj.cardnumber),
      			   					category: obj.category,
      			   					fixed: obj.fixed,
      			   					fixedPeriod: obj.fixedperiod,
      			   					fixedMemo: obj.fixedMemo,
      			   					seq: obj.seq,
      			   					seqacc: obj.seqacc,
      			   					seqrcc: obj.seqrcc
         						}
         					})
         				})
        			},
         			error: function(a,b,c){
         				console.log(a,b,c);
         			}
         		 }) 
          ],
    		eventClick: function(info) {
                console.log('workd');
    		    info.jsEvent.preventDefault();
    		    currentEventId = info.event.id;
    		    var event = calendar.getEventById(currentEventId);
                var container = document.getElementById("eventProduceModal");//
                var modal = new bootstrap.Modal(container);
                
                var content = info.event.extendedProps.content;
                
                var start = info.event.start.toISOString().slice(0, 16);
                var category = info.event.extendedProps.category;
                var useLocation = info.event.extendedProps.useLocation;
                var paymentMethod = info.event.extendedProps.paymentMethod;
                var amountindicator = info.event.extendedProps.amountindicator;
                var amount = info.event.extendedProps.amount;
                var isFixedExpense = info.event.extendedProps.fixed;
                var seq = info.event.extendedProps.seq;
                var seqacc = info.event.extendedProps.seqacc;
                var seqrcc = info.event.extendedProps.seqrcc;
                var fixed = info.event.extendedProps.fixed;
                var period = info.event.extendedProps.fixedPeriod;
                var memo = info.event.extendedProps.fixedMemo;
                
                console.log(seq);
                $('#eventModalcontent').val(info.event.extendedProps.content); 
                $('#eventModalStart').val(info.event.start.toISOString().slice(0, 16)); 
                $('.modalselectcategory').val(info.event.extendedProps.category);
                $('#eventModaluseloc').val(info.event.extendedProps.useLocation);
                $('.modalmethodofpayment').val(info.event.extendedProps.paymentMethod);
                $('.modalmethodofpayment').val(amountindicator);
                $('.modalincreasedecrease').val(info.event.extendedProps.amountindicator);
                $('#eventModalIoc').val(info.event.extendedProps.amount);
                var checkbox = document.getElementById('fixedexpense');
                
                
                
                var checkbox = document.getElementById('fixedexpense');
                checkbox.checked = fixed > 0;
                
                console.log(info);
                console.log(memo);
                console.log(period);
                procbutton.style.display = 'none';
                editbutton.style.display = 'inline-block';
                delbutton.style.display = 'inline-block';
                
                console.log(info.event.extendedProps.amountindicator);
                console.log(info.event.extendedProps.paymentMethod);
                console.log(fixed);
            	modal.show();
            	if (fixed>0) {
                    console.log('Checkbox checked status:', checkbox.checked);
                    checkbox.checked = true;
                    console.log('Checkbox checked status:', checkbox.checked);
                    fixedDateDiv.style.display = 'block';
                } else {
                    console.log('Checkbox not found');
                }
            	
            	if(period ==='1'){
                    $('.modalfixedperiod').val('월');
            	}
                    $('#eventModalMemo').val(memo);
                
                /* eventProduceModal.addEventListener('hidden.bs.modal', function () {
                    window.location.reload();
                }); */

    			$('#deleteEventBtn').off().on('click', function() {
    				if(window.confirm('일정을 삭제하시겠습니까?')){
    					if(delRequest !== null){
    						delRequest.abort();
    					}
    				}
    				
    				delRequest = $.ajax({
    					type:'post',
    					url:'/account/account/calendardelete.do',
    					data:{
    						seq: seq
    					},
    				dataType: 'json',
	                    success: function (response) {
	                        alert('Edit successful');
	                        modal.hide();
	                        
	                    },
	                    error: function (xhr, status, error) {
	                        alert('Error: ' + xhr.responseText);
	                        modal.hide();
	                    }
    				})
    				info.event.remove();
    				modal.hide();
    			});
    			$("#editEventBtn").off().on('click', function() {
    			    
    			    
    			    if(confirm('항목을 수정하시겠습니까?')){
    					// 중복 실행 방지
    					if (editRequest !== null) {
    						editRequest.abort();
    					}
    					
    			        editRequest = $.ajax({
    			            type:'post',
    			            url: '/account/account/calendaredit.do',
    			            data: {
    			            	start: document.getElementById('eventModalStart').value,
    	                        useLocation: document.getElementById('eventModaluseloc').value,
    	                        content: document.getElementById('eventModalcontent').value,
    	                        amount: document.getElementById('eventModalIoc').value,
    	                        amountindicator: document.getElementsByClassName('modalincreasedecrease')[0].value,
    	                        paymentMethod: document.getElementsByClassName('modalmethodofpayment')[0].value,
    	                        category: categories.indexOf(document.getElementsByClassName('modalselectcategory')[0].value),
    	                        fixed: fixed,
    	                	    period: document.getElementsByClassName('modalfixedperiod')[0].value,
    	                	    memo: document.getElementsByClassName('fixedmemo')[0].value,
    	                        seq: seq,
    	                        seqacc: seqacc,
    	                        seqrcc: seqrcc
    			            },
    			            dataType: 'json',
    	                    success: function (response) {
    	                        alert('Edit successful');
    	                        modal.hide();
    	                        if (response) {
    	                            console.log(response);
    	                            //calendar.refetchEvents();
    	                            info.event.remove();
    	                            var event = {
    	                                    title: document.getElementsByClassName('modalselectcategory')[0].value,
    	                                    start: document.getElementById('eventModalStart').value,
    	                                    allDay: true,
    	                                    color: colors[document.getElementsByClassName('modalselectcategory')[0].value], 
    	                                    extendedProps: {
    	                                        useLocation: document.getElementById('eventModaluseloc').value,
    	                                        content: document.getElementById('eventModalcontent').value,
    	                                        category: document.getElementsByClassName('modalselectcategory')[0].value,
    	                                        paymentMethod: document.getElementsByClassName('modalmethodofpayment')[0].value,
    	                                        amount: document.getElementById('eventModalIoc').value,
    	                                        amountindicator: document.getElementsByClassName('modalincreasedecrease')[0].value,
    	                                        isFixedExpense: document.getElementById('fixedexpense').checked ? '1' : '0',
    	                                       	fixed: fixed,
    	                                        seq: seq,
    	                    	                seqacc: seqacc,
    	                    	                seqrcc: seqrcc
    	                                    }
    	                                };
    	                            
    	                            calendar.addEvent(event);
    	                            
    	                        }
    	                        //calendar.refetchEvents();
    	                       
    	                    },
    	                    error: function (xhr, status, error) {
    	                        alert('Error: ' + xhr.responseText);
    	                        modal.hide();
    	                        calendar.refetchEvents();
    	                    }
    			            
    			        })
    			    }
    			});
    		},
    		
    		eventMouseEnter: function (info) {
                console.log('in')
    			var popover = new bootstrap.Popover(info.el, {
    				title: $('<div />', {
    					text: info.event.title
    				}).css({
    					'color': info.event.backgroundColor != '' ? info.event.backgroundColor : '#3788D8',
    					'font-weight': 'bold',
    					'font-size': '20px'
    				}),
                    content: $('<div />', {
                class: 'popoverInfoEvent'
            }).append('<strong>내용:</strong> ' + info.event.extendedProps.category + '<br>')
            .append('<strong>금액:</strong> '+info.event.extendedProps.amountindicator + info.event.extendedProps.amount + '<br>')
            ,
            trigger: 'hover',
            delay: { show: 400, hide: 300 },
            placement: 'top',
            html: true,
            container: 'body'
    			});
    			setTimeout(function () {
    			popover.dispose();
    			}, 1500); 
    		},
    		dateClick: function(info) {
                console.log('dateclick',info.dateStr);
            clearModalInputs(); // Clear all modal inputs first
            var dateValue = new Date(info.dateStr);
            var localDate = new Date(dateValue.getTime() - dateValue.getTimezoneOffset() * 60000);
            var dateISOString = localDate.toISOString().slice(0, 16);
        
        	document.getElementById('eventModalStart').value = dateISOString;
        
            
            var modal = new bootstrap.Modal(document.getElementById('eventProduceModal'));
            procbutton.style.display='inline-block';
            editbutton.style.display='none';
            delbutton.style.display='none';
            modal.show();
          },
          select: function(info) {
            
          },
    	  locale: 'ko',
          headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay'
          },
          initialDate: new Date(),
          navLinks: true, // can click day/week names to navigate views
        //   businessHours: true, // display business hours
          editable: true,
          selectable: true,
          /* events:[
            {
              title: 'event 1',
              start: '2024-05-01',
            }
          ], */
          /* events: [
        	  $.ajax({
         			type: 'get',
         			url: '/account/account/calendarjson.do',
         			dataType: 'json',
         			success: function(result){
         				result.forEach(obj =>{
         					calendar.addEvent({
         						title: obj.category ,
         						allDay: true,
         						start: obj.start,
         						color: colors[obj.category], 
         						extendedProps: {
      			   					useLocation: obj.loc,
      			   					content: obj.content,
      			   					amount: obj.amount,
      			   					amountindicator: (obj.amountindicator==='출금'?'+':'-'),
      			   					paymentMethod : (obj.paymentMethod+'\xa0'+obj.aliasname+':'+obj.cardnumber),
      			   					category: obj.category,
      			   					fixed: obj.fixed,
      			   					fixedPeriod: obj.fixedperiod,
      			   					seq: obj.seq,
      			   					seqacc: obj.seqacc,
      			   					seqrcc: obj.seqrcc
         						}
         					})
         				})
        			},
         			error: function(a,b,c){
         				console.log(a,b,c);
         			}
         		 }) 
          ] */
        });
     	//alert(222);
        calendar.render();
      });
    
    //setTimeout(()=>{alert();calendar.render();}, 3000);
    
    let isEdit = false;

    document.addEventListener('DOMContentLoaded', function() {
        const addForm = document.getElementById('addWishItemForm');
        const wishList = document.getElementById('wishListItems');
        const wishInput = document.getElementById('wishInput');
                
        /* 
        eventProduceModal.addEventListener('hidden.bs.modal', function () {
            window.location.reload();
        }); 
        */

        const wishlistcheckbox = document.getElementById('addcheckbox');
        console.log(wishlistcheckbox);
        
        wishlistcheckbox.addEventListener('change', function() {
            if (this.checked) {
                console.log('Checkbox is checked');
                openEventModal();
            }
        });
       
    });

    //위시리스트
    
    document.addEventListener('DOMContentLoaded', function() {
        const addButton = document.getElementById('addrightnow');
        const newItemInput = document.getElementById('newItemInput');
        const wishList = document.getElementById('wishListItems');
        const newItemButton = document.getElementById('newItemButton');
        const cbcbbox = document.getElementById('addcheckbox');
        const delitembtn = document.getElementById('listdelbutton');
        

        // Toggle input field visibility and focus when the button is clicked
        addButton.onclick = function() {
            if (newItemInput.style.display === 'none') {
                newItemInput.style.display = 'block';
                newItemButton.style.display = 'block';
                newItemInput.focus();
            } else {
                newItemInput.style.display = 'none';
                newItemButton.style.display = 'none';
            }
        };

        // Function to add a new transaction item to the wish list
        function addNewTransContent(itemText) {
            const transContent = document.createElement('div');
            transContent.id = 'transcontent';
        
            const checkbox = document.createElement('input');
            checkbox.type = 'checkbox';
            checkbox.className = 'frontback';
            checkbox.id = 'addcheckbox';

            const transDesc = document.createElement('div');
            transDesc.className = 'transin';
            transDesc.id = 'transdate';
            transDesc.textContent = itemText;

            const deleteBtn = document.createElement('div');
            deleteBtn.className = 'frontback';
            deleteBtn.id = 'listdelbutton';
            deleteBtn.innerHTML = '<div id="listdelbutton" class="frontback"><i class="fa-solid fa-xmark"></i></div>';
            deleteBtn.onclick = function() {
                wishList.removeChild(transContent);
                
                let contentOfTransDate = transDesc.textContent;
                console.log('Deleting item with transdate content:', contentOfTransDate);
                
                delwishlist(contentOfTransDate);
            };

            transContent.appendChild(checkbox);
            transContent.appendChild(transDesc);
            transContent.appendChild(deleteBtn);

            wishList.appendChild(transContent);
        }
        
         

        newItemInput.addEventListener('keypress', function(event) {
            if (event.key === 'Enter') {
                event.preventDefault();
                const text = newItemInput.value.trim();
                if (text) {
                    addNewTransContent(text);
                    newItemInput.value = ''; 
                    newItemInput.style.display = 'none'; 
                    newItemButton.style.display = 'none';  
                    sendwishlist(text);
                }
            }
        });
        newItemButton.addEventListener('click', function() {
            const text = newItemInput.value.trim();
            if (text) {
                addNewTransContent(text);
                newItemInput.value = ''; 
                newItemInput.style.display = 'none'; 
                newItemButton.style.display = 'none';  
                sendwishlist(text);
            }
        });
         
        
        $(document).ready(function() {
            // AJAX request to fetch data as soon as the page loads
            $.ajax({
                url: '/account/account/wishlist.do', // Replace with your actual URL
                type: 'GET',
                dataType: 'json',
                success: function(data) {
                    $.each(data, function(index, item) {
                        // Access the 'productName' property of each item
                        if (item.productName) { // Ensure that productName exists
                            console.log(item.productName);
                            addNewTransContent(item.productName); // Add each product name to the wishlist
                            
                        }
                    });
                    console.log('done?');
                },
                error: function(xhr, status, error) {
                    console.error('Error fetching data:', error);
                }
            });
            });

     
            
            
        wishList.addEventListener('change', function(event) {
            // Check if the event target is a checkbox with the class 'frontback'
            if (event.target.type === 'checkbox' && event.target.classList.contains('frontback')) {
                // Check if the checkbox is checked
                if (event.target.checked) {
                    console.log('Checkbox is checked');
                    var container = document.getElementById("eventProduceModal");//
                    var modal = new bootstrap.Modal(container);
                    let content = document.getElementById('transdate').innerHTML;
                        clearModalInputs();
                        $('#eventModalcontent').val(content); 
                        console.log(content);
                    modal.show();
                    event.target.checked=false;
                }
            }
        });
	
       	function sendwishlist(text){
       	 $.ajax({
             url: '/account/account/wishlist.do', // Replace with your actual URL
             type: 'post',
             data: {
                 item: text
             },
             success: function(response) {
                 console.log('sent');
             },
             error: function(xhr, status, error) {
                 console.error('Error fetching data:', error);
             }
         });
       	}
        
       	function delwishlist(text){
             if(window.confirm('삭제하시겠습니까?')){
 				if(delRequest !== null){
 					delRequest.abort();
 					console.log('abort');
 				}
 			}
             console.log(text);
 			delRequest = $.ajax({
 				url:'/account/account/delwishlist.do',
 				type:'post',
 				data:{
 					content: text
 				},
                 success: function (response) {
                     alert('Edit successful');
                     
                 },
                 error: function (xhr, status, error) {
                     alert('Error: ' + xhr.responseText);
                 }
 			})
         }; 
       	
    });

    </script>
</body>

</html>
