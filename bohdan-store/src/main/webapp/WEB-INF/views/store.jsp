<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/14/2018
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Store</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
            integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">CBS</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/WEB-INF/views/store.jsp">Store</a></li>
            <c:if test="${user.role ne 'user'}">
                <li><a href="/customers.jsp">Customers</a></li>
            </c:if>
        </ul>
        <ul class="nav navbar-nav navbar-right" style="font-size: large">
            <%--<li>Welcome, <%=((User) request.getSession().getAttribute("user")).getUsername()%>
            </li>--%>
            <li class="nav-item dropdown">
                <span class="glyphicon glyphicon-piggy-bank"></span>
                <a class="nav-link dropdown-toggle btn-success" href="#" id="navbarDropdown" role="button"
                   data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Cart
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <c:forEach var="cartedProduct" items="${cartedProducts}">
                        <a class="dropdown-item" href="#">${cartedProduct.name} <b>${cartedProduct.price}</b></a>
                    </c:forEach>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">/do payment</a>
                </div>
            </li>
            <li><a href="/store?action=logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <br>
        <div class="panel panel-primary">
            <div class="panel-heading">Store</div>
            <div class="panel-body">
                <div class="col-lg-3 col-md-3">
                    <c:if test="${deletedEmployee eq null}">
                        <c:if test="${updatedEmployee eq null}">
                            <br><br>
                            <form action="/store" method="get">
                                <label for="search">Search:</label><br>
                                <input class="form-control" type="text" placeholder="Enter product name..." id="search"
                                       name="search">
                                <button type="submit" class="btn btn-info btn-block"><span
                                        class="glyphicon glyphicon-search"
                                        aria-hidden="true"></span></button>
                            </form>
                            <br>
                            <c:if test="${user.role ne 'user'}">
                                <button type="button" class="btn btn-primary btn-block" data-toggle="modal"
                                        data-target="#createModal">
                                    Add new product
                                </button>
                            </c:if>
                        </c:if>
                    </c:if>
                    <c:if test="${deletedProduct ne null}">
                        <br>
                        <div class="panel panel-danger">
                            <div class="panel-heading">DELETE</div>
                            <div class="panel-body">
                                <form action="/store" method="post">
                                    <div class="form-group">
                                        <input type="hidden" class="form-control" id="idDel" name="idDel"
                                               value="${deletedProduct.id}">
                                    </div>
                                    <h4>Do you want to delete selected product?</h4>
                                    <div class="form-group">
                                        <a href="/store?action=deleteCancel">
                                            <button type="button"
                                                    class="btn btn-danger form-control">
                                                Cancel
                                            </button>
                                        </a>
                                        <button type="submit"
                                                class="btn btn-success form-control">
                                            Submit
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${updatedProduct ne null}">
                        <br>
                        <div class="panel panel-info">
                            <div class="panel-heading">UPDATE</div>
                            <div class="panel-body">
                                <form action="/store" method="post">
                                    <div class="form-group">
                                        <input type="hidden" class="form-control" id="idUpd"
                                               name="idUpd"
                                               value="${updatedProduct.id}">
                                    </div>
                                    <div class="form-group">
                                        <label for="nameUpd">Name:</label>
                                        <input type="text" class="form-control"
                                               id="nameUpd"
                                               name="nameUpd"
                                               value="${updatedProduct.name}">
                                    </div>
                                    <div class="form-group">
                                        <label for="priceUpd">Price:</label>
                                        <input type="number" class="form-control" id="priceUpd"
                                               name="priceUpd"
                                               value="${updatedProduct.price}">
                                    </div>
                                    <div class="form-group">
                                        <label for="imageUpd">Image source:</label>
                                        <input type="text" class="form-control" id="imageUpd"
                                               name="imageUpd"
                                               value="${updatedProduct.image}">
                                    </div>
                                    <div class="form-group">
                                        <a href="/store?action=updateCancel">
                                            <button type="button"
                                                    class="btn btn-danger form-control">
                                                Cancel
                                            </button>
                                        </a>
                                        <button type="submit"
                                                class="btn btn-success form-control">
                                            Submit
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </c:if>
                </div>
                <!-- Modal -->
                <div id="createModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="createModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h3 class="modal-title">Product:</h3>
                            </div>
                            <div class="modal-body">
                                <div class="panel panel-primary">
                                    <div class="panel-heading">CREATE</div>
                                    <div class="panel-body">
                                        <form action="/store" method="post">
                                            <div class="form-group">
                                                <input type="hidden" class="form-control" id="idCr" name="idCr"
                                                       value="0">
                                            </div>
                                            <div class="form-group">
                                                <label for="nameCr">Name:</label>
                                                <input type="text" class="form-control" id="nameCr" name="nameCr">
                                            </div>
                                            <div class="form-group">
                                                <label for="priceCr">Price:</label>
                                                <input type="number" class="form-control" id="priceCr" name="priceCr">
                                            </div>
                                            <div class="form-group">
                                                <label for="imageCr">Image source:</label>
                                                <input type="text" class="form-control" id="imageCr" name="imageCr">
                                            </div>
                                            <div class="form-group">
                                                <button type="button" class="btn btn-danger form-control"
                                                        data-dismiss="modal">
                                                    Cancel
                                                </button>
                                                <button type="submit" class="btn btn-success form-control">Submit
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8 col-md-8">
                    <c:forEach var="product" items="${products}">
                        <form action="/store" method="post">
                            <div class="form-group">
                                <input type="hidden" class="form-control" id="id" name="id" value="${product.id}">
                            </div>
                            <div class="form-group">
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="${product.image}" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">${product.name}</h5>
                                        <p class="card-text">${product.price}</p>
                                        <a href="#" class="btn btn-primary">Add to cart</a>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                </button>
                                <button type="submit" class="btn btn-success form-control">Add to cart
                                </button>
                            </div>
                            <c:if test="${user.role eq 'admin'}">
                                <div class="form-group">
                                    <a href="/store?action=update&idUpd=${product.id}">
                                        <button type="button" class="btn info">
                                                    <span class="glyphicon glyphicon-refresh"
                                                          aria-hidden="true"></span>
                                        </button>
                                    </a>
                                </div>
                                <div class="form-group">
                                    <a href="/store?action=delete&idDel=${product.id}">
                                        <button type="button" class="btn btn-danger">
                                                    <span class="glyphicon glyphicon-trash"
                                                          aria-hidden="true"></span>
                                        </button>
                                    </a>
                                </div>
                            </c:if>
                        </form>
                    </c:forEach>
                    <%--<ul class="pagination justify-content-center">
                        <c:forEach var="i" begin="1" end="${pageAmount}">
                            <li class="page-item"><a class="page-link" href="/employees?page=${i}">${i}</a></li>
                        </c:forEach>
                    </ul>--%>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
