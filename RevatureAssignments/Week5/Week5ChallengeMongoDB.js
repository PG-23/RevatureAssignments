/* Week 5 Challenge w/ MongoDB
 * By Patrick Guinn
 * 9/22/26
 */

// Create a products collection on a gadgetStore database using a validator
db.createCollection("products", {
  validator: {
    $jsonSchema: {
      title: "products",
      bsonType: "object",
      required: ["name", "price", "inStock"],
      properties: {
        name: {
          bsonType: "string",
          description: "must be a string and is required"
        },
        price: {
          bsonType: ["double", "int", "decimal"],
          minimum: 0,
          description: "must be a non-negative number and is required"
        },
        inStock: {
          bsonType: "bool",
          description: "must be a boolean and is required"
        }
      }
    }
  }
})

// Insert Many
db.products.insertMany([
  {name: "Wireless Mouse", price: 50.00, inStock: false, specs: {brand: "Logitech"}},
  {name: "Mechanical Keyboard", price: 120, inStock: true, specs: {brand: "Logitech"}},
  {name: "Gaming Monitor", price: 670.00, inStock: true, specs: {brand: "Logitech"}},
])

// Insert One to test validator
db.products.insertOne({name: 50, price: "Wireless Mouse", inStock: "True"})
MongoServerError: Document failed validation

// Update One using $set and $inc
db.products.updateOne({name: "Wireless Mouse"}, {$set: {category: 'Accessories'}, $inc: {price: 15}})

// Update One using push to create new tags array
db.products.updateOne({name: "Wireless Mouse"}, {$push: {tags: 'wireless'}})

// Update One using push to add 'bestseller' to tags
db.products.updateOne({name: "Wireless Mouse"}, {$push: {tags: 'bestseller'}})

// Update One using pull to remove 'wireless from tags
db.products.updateOne({name: "Wireless Mouse"}, {$pull: {tags: 'wireless'}})

// Find products using $gte
db.products.find({price: {$gte: 100}}, {name: 1, price: 1, inStock: 1})

// Find specific brand using dot notation
db.products.find({"specs.brand": 'Logitech'})

// Find product with a given category found in list using $in
db.products.find({"specs.brand": {$in: ['Logitech', 'Razor', 'Asus']}})

// Insert a document into orders that links a products _id to the order
	// Part 1
db.products.findOne({ name: "Wireless Mouse" }, { _id: 1})
	// Output with id to reference
{
  _id: ObjectId('6ab1914db7e2ddf9482824f5')
}
	// Part 2
db.orders.insertOne({
  productId: ObjectId("6ab1914db7e2ddf9482824f5"),
  quantity: 2
})

//Aggregation pipeline on orders using $lookup and $unwindjoin orders with products
db.orders.aggregate([
  {
    $lookup: {
  		from: "products",
    	localField: "productId",
      foreignField: "_id",
      as: "productDetails"
    }
  },
  {
    $unwind: "$productDetails"
  }
])

// Output a clean customer receipt using $project that shows product name and ordered quantity but hides the _id field
db.orders.aggregate([
  {
    $lookup: {
      from: "products",
      localField: "productId",
      foreignField: "_id",
      as: "product"
    }
  },
  {
    $unwind: "$product"
  },
  {
    $project: {
      _id: 0,
      "product.name": 1,
      quantity: 1
    }
  }
])


