import CoreLocation
class Park: CustomStringConvertible {
    private var parkName : String = ""
    private var parkLocation : String = ""
    private var dateFormed : String = ""
    private var area : String = ""
    private var link : String = ""
    
    private var location : CLLocation?
    private var imageLink : String = ""
    private var parkDescription : String = ""
    
    convenience init () {
        self.init(parkName: "Unknown", parkLocation: "Unknown", dateFormed: "Unknown", area: "Unknown", link: "Unknown", location: nil, imageLink: "Unknown", parkDescription: "Unknown")
    }
    
    init(parkName: String, parkLocation: String, dateFormed: String, area: String, link: String, location: CLLocation?, imageLink: String, parkDescription: String){
        self.set(parkName: parkName)
        self.set(parkLocation: parkLocation)
        self.set(dateFormed: dateFormed)
        self.set(area: area)
        self.set(link: link)
        self.set(location: location)
        self.set(imageLink: imageLink)
        self.set(parkDescription: parkDescription)
    }
    
    func getParkName() -> String {
        self.parkName
    }
    func set(parkName: String) {
        let name_trimmed: String = self.trim(parkName);
        if name_trimmed.count >= 3 && name_trimmed.count <= 75 {
            self.parkName = name_trimmed
            return
        }
        self.parkName = "TBD"
        print("Bad value of \(parkName) in set(ParkName): setting to TBD")
    }
    
    func getParkLocation() -> String {
        self.parkLocation
    }
    
    func set(parkLocation: String) {
        let location_trimmed: String = self.trim(parkLocation);
        if location_trimmed.count >= 3 && location_trimmed.count <= 75 {
            self.parkLocation = location_trimmed
            return
        }
        self.parkLocation = "TBD"
        print("Bad value of \(parkLocation) in set(ParkLocation): setting to TBD")
    }
    
    func getDateFormed() -> String {
        self.dateFormed
    }
    
    func set(dateFormed: String) {
        self.dateFormed = dateFormed
    }
    
    func getArea() -> String {
        self.area
    }
    
    func set(area: String) {
        self.area = area
    }
    
    func getLink() -> String {
        self.link
    }
    
    func set(link: String) {
        self.link = link
    }
    
    func getLocation(locaiton: CLLocation) -> CLLocation?{
        self.location
    }
    
    func set(location: CLLocation?) {
        self.location = location
    }
    
    func getImageLink() -> String{
        self.imageLink
    }
    
    func set(imageLink: String) {
        self.imageLink = imageLink
    }
    
    func getParkDescription() -> String{
        self.parkDescription
    }
    
    func set(parkDescription: String) {
        self.parkDescription = parkDescription
    }
    
    func trim(_ txt: String) -> String{
        var str: String = txt
        str = str.trimmingCharacters(in: .whitespacesAndNewlines)
        var str_trim: String = ""

        for i in 0..<str.count{
            if(!(Array(str)[i] == " " && Array(str)[i] == Array(str)[i + 1])){
                str_trim += String(Array(str)[i])
            }
        }
        
        return str_trim
    }
    
    var description: String {
            return """
            {
            parkName: \(self.parkName)
            parkLocation: \(self.parkLocation)
            dateFormed: \(self.dateFormed)
            area: \(self.area)
            link: \(self.link)
            location: \(self.location)
            imageLink: \(self.imageLink)
            parkDescription: \(self.parkDescription)
            }
            """
    }
}

let p1: Park = Park()
//let p1: Park = Park("test1","test2","test3","test4","test5")

let p2 : Park = Park(parkName: "Acadia National Park", parkLocation: "Maine", dateFormed: "1919-02-26", area: "47,389.67 acres (191.8 squarekm)", link: "TBD", location: nil, imageLink: "TBD", parkDescription: "TBD")
print("\(p1)")
print("\(p2)")

p2.set(link: "http://en.wikipedia.org/wiki/Acadia_National_Park")
print("\(p2)")

let p3 = Park(parkName: "ab", parkLocation: "na", dateFormed: "1919-02-26", area: "47,389.67 acres (191.8 square km)", link: "TBD", location: nil, imageLink: "TBD", parkDescription: "TBD")
print("\(p3)")
