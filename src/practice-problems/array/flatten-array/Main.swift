
func flatten(_ array: [Any]) -> [Any] {
  var buffer = [Any]()
  
  return flatten(array, buffer: &buffer)
}

func flatten(_ array: [Any], buffer: inout [Any]) -> [Any] {
  for item in array {
    if let anArray = item as? [Any] {
      buffer = flatten(anArray, buffer: &buffer)
    } else {
      buffer.append(item)
    }
  }
  
  return buffer
}

let result = flatten([1, 2, 3, 4, 5, [6, [7]]])
print(result)
