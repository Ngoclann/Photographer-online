
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/home.css" rel="stylesheet" type="text/css">
        <title>Gallery</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="about">
                        <h3>${gallery.name}</h3>
                    </div>
                    <c:if test="${error != null}">
                        <h3 style="margin-bottom: 600px"> ${error}</h3>
                    </c:if>

                    <c:if test="${error == null}">
                        <div class="imageGaler">
                            <!-- Slideshow -->
                            <c:set var="cout" value="1"/>
                            <ul id="slides">
                                <c:forEach var="i" items="${listImage}">

                                    <c:if test="${cout eq 1}">
                                        <li class="slide showing">
                                        </c:if>
                                        <c:if test="${cout ne 1}">
                                        <li class="slide">
                                        </c:if>
                                        <img src="${i.image_url}">
                                    </li>
                                    <c:set var="cout" value="${cout + 1}"/>

                                </c:forEach>     
                            </ul>
                            <!--end slideshow-->
                            <br>
                            <button class="controls" id="pause">Pause</button>
                        </div>
                        <div class="contentGallery">
                            <c:if test="${error == null}">
                                <ul>
                                    <c:if test="${index <= maxPage}">
                                        <c:forEach items="${listImage}" var="i" varStatus="loop">
                                            <li class="span4">
                                                <a href="GalleryServlet?index=${index}&galleryID=${galleryID}&imgID=${i.id}">
                                                    <img src="${i.image_url}"></a>
                                            </li>
                                        </c:forEach>
                                    </c:if>
                                </ul>
                            </c:if>

                            <div class="paging">
                                <c:if test="${maxPage > 1}">
                                    <c:forEach begin="1" end="${maxPage}" var="i">
                                        <a class="${i==index?"active":""}" href="GalleryServlet?index=${i}&galleryID=${galleryID}">${i}</a>
                                        <c:set var="index" value="${index}" />
                                    </c:forEach>
                                </c:if>
                            </div>
                        </div>

                    </c:if>

                </div>
                <div class="right">
                    <jsp:include page="ShareBox.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>


        <!--Slide JS-->
        <script type="text/javascript">
            var slides = document.querySelectorAll('#slides .slide');
            var currentSlide = 0;
            var slideInterval = setInterval(nextSlide, 1000);

            function nextSlide() {
                slides[currentSlide].className = 'slide';
                currentSlide = (currentSlide + 1) % slides.length;
                slides[currentSlide].className = 'slide showing';
            }

            var playing = true;
            var pauseButton = document.getElementById('pause');

            function pauseSlideshow() {
                pauseButton.innerHTML = 'Play';
                playing = false;
                clearInterval(slideInterval);
            }

            function playSlideshow() {
                pauseButton.innerHTML = 'Pause';
                playing = true;
                slideInterval = setInterval(nextSlide, 2000);
            }

            pauseButton.onclick = function () {
                if (playing) {
                    pauseSlideshow();
                } else {
                    playSlideshow();
                }
            }
            ;
        </script>
        <!--End Slide JS-->

    </body>
</html>
