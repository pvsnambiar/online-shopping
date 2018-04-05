<div class="container">
	<div class="row">
		<!-- display slide bar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>

		</div>
		<!-- display products -->
		<div class="col-md-9">
			<!--  added breadcrum component -->
			<div class="row">
				<div class="col-md-12">
					<c:if test="${userClickAllProducts == true }">
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</a></li>

						</ol>
					</c:if>
					<c:if test="${userClickCategoryProducts == true}">
						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</a></li>
							<li class="active">${category.name}</a></li>

						</ol>
					</c:if>

				</div>

			</div>

		</div>

	</div>




</div>