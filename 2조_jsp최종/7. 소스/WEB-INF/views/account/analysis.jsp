<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<title>BudgetBuddy | 가계부 분석</title>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
         <link type="image/png" sizes="16x16" rel="icon" href="/account/asset/images/icons8-돈-상자-16.png">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
<!--     <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> -->
    <link rel="preconnect" href="https://fonts.gstatic.com" >
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <!-- Libraries Stylesheet -->
</head>
<style>


    
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
				<div class="content-header">
					<div class="content-title-style">
						<h3>가계부 분석</h3>
					</div>
					
					<form method="GET">
						<div id="periodcheck" class="btn-group-style date-period-box">
							<button name="period" value="day" class="purple-btn button">일일</button>
							<button name="period" value="week" class="purple-btn button">주간</button>
							<button name="period"  value="month" class="purple-btn button">월간</button>
						</div>
					</form>
				</div>

				<div id="firstrow">
					<!-- Sales Chart Start -->
					<div id="chart01">

						<div id="pieblock">
							<canvas id="piepie" class="pie"></canvas>
						</div>
					</div>

					<div id="chart02">
						<div id="pieblock">
							<canvas id="piepie2" class="pie"></canvas>
						</div>
					</div>


					<div id="customMsg">
						<div>
							<div>
								지난 달 가장 많이 소비한 <br> 카테고리는 <span class="max-spending-category-brown">"${categoryUsageMap.acName}"</span>입니다.						
							</div><br>
							<div>							
								지난 달은 <span class="spending-price-red">${categoryUsageMap.beforeAcUsage}원</span>을 사용했고, <br>
								이번 달은 <span class="spending-price-red">${categoryUsageMap.nowAcUsage}원</span>을 사용했습니다. <br>
							</div><br>
							<div class="analysis-comment-style">
								<c:if test="${categoryUsageMap.beforeAcUsage > categoryUsageMap.nowAcUsage}">
    								지난 달보다 ${categoryUsageMap.acName}에서 지출이 줄었네요!<br>
    								현재를 유지해보세요!
								</c:if>

								<c:if test="${categoryUsageMap.beforeAcUsage < categoryUsageMap.nowAcUsage}">
									지난 달보다 ${categoryUsageMap.acName}에서 지출이 늘었네요.<br>
									주의해주세요!
								</c:if>
								<c:if test="${categoryUsageMap.beforeAcUsage == categoryUsageMap.nowAcUsage}">
									지난 달과 동일하게 사용했네요.<br>
									${categoryUsageMap.acName}에서 지출을 줄여보세요!
								</c:if>
							</div>
							
						</div>
					
					</div>
					
					<div id="chartLegend"></div><br>

					<!-- Sales Chart End -->
				</div>

				<div id="secondrow">
					<div id="monthgoal" class="box">
						저축 목표 기간 <span class="anyalysis-period-num">${challengeInfoMap.spPeriod}개월</span><br>
						저축 목표 금액 <span class ="anyalysis-goals-price" >${challengeInfoMap.savingsGoals}원</span><br>
						현재 저축 금액 <span class ="anyalysis-savings-price" >${challengeInfoMap.totalSaving}원</span><br>
						남은 저축 금액 <span class ="anyalysis-remaining-price" >${challengeInfoMap.remainingSavings}원</span>
					</div>
					<div id="currentsituation" class="box">
						<div>저축 목표 기간 중 <span class="anyalysis-period-num">${challengeInfoMap.monthsSinceJoin}개월</span>이 지났습니다!</div><br>
						<div>이번 달 지출금은 총 <span class="spending-price-red">${challengeInfoMap.monthUsage}원</span>,<br> 월 평균 지출금은 <span class="spending-price-red">${challengeInfoMap.avgMonthlySpending}원</span>입니다.</div><br>
						<c:if test="${challengeInfoMap.goalAchievementPeriod <= 0}">
							<div class ="anyalysis-goals-price" >목표 저축 금액까지 소요 예상 기간을 계산할 수 없습니다.</div><br>
							<div><span class="anyalysis-period-num">${challengeInfoMap.spPeriod - challengeInfoMap.monthsSinceJoin}개월</span> 안에 목표 금액을 저축하려면</div>
							<div>매달 평균 <span class ="anyalysis-remaining-price" >${challengeInfoMap.avgMonthlySavingsPrice}원</span>을 저축해야합니다!</div>
						</c:if>
						<c:if test="${challengeInfoMap.goalAchievementPeriod > 0}">
							<div>이 기세로는 목표 저축 금액까지 <span class="anyalysis-period-num">${challengeInfoMap.goalAchievementPeriod}개월</span>이 필요합니다!</div><br>
							<div><span class="anyalysis-period-num">${challengeInfoMap.spPeriod - challengeInfoMap.monthsSinceJoin}개월</span> 안에 목표 금액을 저축하려면</div>
							<div>매달 평균 <span class ="anyalysis-remaining-price" >${challengeInfoMap.avgMonthlySavingsPrice}원</span>을 저축해야합니다!</div>
							<div>이번 달은 <span class ="usable-price-num">${challengeInfoMap.avgMonthlyUsablePrice}원</span>을 사용할 수 있으며,</div>
							<div>일 평균 <span class ="usable-price-num">${challengeInfoMap.avgDailyUsablePrice}원</span>을 사용할 수 있습니다.</div>
						</c:if>
					</div>
				</div>
				
				<div id="thridrow">
					<div>
						<h5><span class="max-spending-category-subtitle-brown">"${acName}"</span> 관련 최근 경제 뉴스</h5>
					</div>
					<div id="news-content" class="box full-box">
						<c:forEach items="${newsList}" var="dto" varStatus="loop">
							<div>
								<div><a id="news-title" target="_blank" href="${dto.link}">${dto.title}</a> ${dto.pubDate}<br></div>
								<div>${dto.description}</div>
							<c:if test="${!loop.last}">
								<div id="analysis-hr"><hr></div>
							</c:if>
							</div>
						</c:forEach>
					</div>
				</div>

			</div>
		</div>
	</div>

		<!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.1/chart.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
   
    <!-- Template Javascript -->
    <script src="${pageContext.request.contextPath}/asset/css/temp/js/main.js"></script>
    <script>
    
    document.addEventListener('DOMContentLoaded', function() {
        // 현재 URL에서 'period' 매개변수 값 가져오기
        const urlParams = new URLSearchParams(window.location.search);
        let periodParam = urlParams.get('period');

        // 선택된 값이 없을 때 기본값으로 "month" 설정
        if (!periodParam) {
            periodParam = "month";
        }

        // 버튼 요소 가져오기
        const buttonElements = document.querySelectorAll('.purple-btn.button');

        // 'period' 매개변수 값에 따라 해당 버튼에 'active' 클래스 추가
        buttonElements.forEach(function(button) {
            if (button.value === periodParam) {
                button.classList.add('active');
            }
        });
    });
    
    
    let category = [];
    let colors = {}; // 객체로 변경
      
    <c:forEach items="${cList}" var = "dto">
		category.push('${dto.acName}');
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
	category.forEach((categoryName, index) => {
	    colors[categoryName] = colorPalette[index % colorPalette.length];
	});
    
    /* 금액 담을 배열 */
    let nowTotalPriceArray = [];
    let nowAcNameArray = [];
    
    let beforeTotalPriceArray = [];
    let beforeAcNameArray = [];
    
    <c:forEach items="${nList}" var = "dto">
    	nowTotalPriceArray.push(${dto.totalPrice});
    	nowAcNameArray.push('${dto.acName}');
    </c:forEach>
    
    <c:forEach items="${bList}" var = "dto">
    	beforeTotalPriceArray.push(${dto.totalPrice});
    	beforeAcNameArray.push('${dto.acName}');
    </c:forEach>
    
	let beforeBackgroundColorArray = beforeAcNameArray.map(categoryName => colors[categoryName]);
	let nowBackgroundColorArray = nowAcNameArray.map(categoryName => colors[categoryName]);

	
	console.log(beforeBackgroundColorArray);
	console.log(nowBackgroundColorArray);
	
	var ctx = document.getElementById('piepie').getContext('2d');
	var chart1 = null;
	if (beforeAcNameArray.length > 0) {
	    chart1 = new Chart(ctx, {
	        type: 'pie',
	        data: {
	            labels: beforeAcNameArray,
	            datasets: [{
	                label: '총 금액',
	                data: beforeTotalPriceArray,
	                backgroundColor: beforeBackgroundColorArray,
	                hoverOffset: 4
	            }]
	        },
	        options: {
	            plugins: {
	                legend: {
	                    display: false
	                }
	            }
	        }
	    });
	}

	var ctx1 = document.getElementById('piepie2').getContext('2d');
	var chart2 = null;
	if (nowAcNameArray.length > 0) {
	    chart2 = new Chart(ctx1, {
	        type: 'pie',
	        data: {
	            labels: nowAcNameArray,
	            datasets: [{
	                label: '총 금액',
	                data: nowTotalPriceArray,
	                backgroundColor: nowBackgroundColorArray,
	                hoverOffset: 4
	            }]
	        },
	        options: {
	            plugins: {
	                legend: {
	                    display: false
	                }
	            }
	        }
	    });
	}

	if (beforeAcNameArray.length === 0 && nowAcNameArray.length === 0) {
	    // 두 차트 모두 데이터가 없을 경우 메시지를 출력
	    document.getElementById('chart02').innerHTML = '<div class="chart-no-data-msg">데이터가 존재하지 않습니다.</div>';
	} else if (beforeAcNameArray.length === 0) {
	    document.getElementById('chart01').innerHTML = '<div class="chart-no-data-msg">비교 데이터가<br>존재하지 않습니다.</div>';
		
	} else if (nowAcNameArray.length === 0) {
	    document.getElementById('chart02').innerHTML = '<div class="chart-no-data-msg">비교 데이터가<br>존재하지 않습니다.</div>';
		
	} else {
	    // 두 차트 중 하나라도 데이터가 있는 경우에만 레전드 생성
	    createSharedCustomLegend([chart1, chart2]);
	}

    
    function createSharedCustomLegend(charts) {
        const legendContainer = document.getElementById('chartLegend');
        legendContainer.innerHTML = ''; // Clear any existing legend content

        const addedCategories = new Set();

        charts.forEach((chart, chartIndex) => {
            chart.data.datasets.forEach((dataset, datasetIndex) => {
                dataset.data.forEach((dataPoint, dataPointIndex) => {
                    const label = chart.data.labels[dataPointIndex];
                    const color = dataset.backgroundColor[dataPointIndex];
                    
                    // 이미 추가된 카테고리인지 확인
                    if (!addedCategories.has(label)) {
                        const legendItem = document.createElement('div');
                        legendItem.innerHTML = `<span style="background-color:\${color}; width: 12px; height: 12px; display: inline-block; margin-right: 5px;"></span> \${label}`;
                        legendItem.style.cursor = 'pointer';
                        legendItem.style.marginRight = '10px';
                        legendContainer.appendChild(legendItem);

                        // Set에 추가
                        addedCategories.add(label);
                    }
                });
            });
        });
    }


	createSharedCustomLegend([chart1, chart2]);


    </script>
</body>

</html>