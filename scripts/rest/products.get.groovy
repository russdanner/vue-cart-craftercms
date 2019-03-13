def results = [:]

/*
results = [ notebooks: [
      [
        name: '123 Notebook Lenovo Ideapad 320 Intel® Core i5-7200u 8GB',
        price: 2259,
        image: 'https://images-americanas.b2w.io/produtos/01/00/item/132381/3/132381386G1.png',
        stars: 5,
        totalReviews: 230,
        details: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s',
      ],
      [
        name: 'Notebook Dell Inspiron i15-3567-A30P Intel Core 7ª i5 4GB',
        price: 2284,
        image: 'https://images-americanas.b2w.io/produtos/01/00/item/133280/7/133280747G1.jpg',
        stars: 3.4,
        totalReviews: 20,
        details: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s',
      ]
 	]
 ]
 */
 
results.notebooks = siteItemService.getSiteTree("/site/components/products/notebooks", 1)//itemsToProducts(siteItemService.getSiteTree("/site/components/products/notebooks", 1))
//results.smartphones = itemsToProducts(siteItemService.getSiteTree("/site/components/products/smartphones", 1))

return results

def itemsToProducts(items) {
	def products = []
    
    items.item.childItems.each { item ->
    	def product = [:]
        product.name = item.queryValue("name").text
        product.details = item.queryValue("detail").text
        product.price = item.queryValue("price").text
        product.image = item.queryValue("image").text
        product.stars = 5 // we'll do this later
        product.totalReviews = 10 // we'll do this later
                
        products.add(product)
    }
    
    return products
}


