def results = [:]
 
results.notebooks = itemsToProducts(siteItemService.getSiteTree("/site/components/products/notebooks", 1))
results.smartphones = itemsToProducts(siteItemService.getSiteTree("/site/components/products/smartphones", 1))

return results

def itemsToProducts(items) {
	def products = []
    
    items.getChildItems().each { item ->
    	def product = [:]
        product.cmsId = item.storeUrl
        product.name = item.queryValue("name")
        product.details = item.queryValue("details")
        product.price = item.queryValue("price")
        product.image = item.queryValue("image")
        product.stars = 5          // we'll do this later
        product.totalReviews = 10  // we'll do this later
                
        products.add(product)
    }
    
    return products
}


