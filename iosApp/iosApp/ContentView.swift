import SwiftUI
import shared

func greet() -> String {
    return Greeting().greeting()
}

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ContentViewModel
    var body: some View {
        NavigationView {
            listView()
        }
    }
    
    private func listView() -> AnyView {
        return AnyView(List(viewModel.actresses, id:\.self) { actress in
            HStack() {
                Text(actress.name)
            }
        })
    }
}
