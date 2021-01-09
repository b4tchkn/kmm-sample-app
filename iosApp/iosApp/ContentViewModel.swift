//
//  ContentViewModel.swift
//  iosApp
//
//  Created by Kakeru Nakabachi on 2021/01/08.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class ContentViewModel: ObservableObject {
    @Published
    var actresses: [Actress] = []
    
    @Published
    var isLoading: Bool = false
    
    private let injector: Injector
    
    private let testRepository: TestRepository
    private let searchActressUseCase: SearchActressUseCase
    
    init(injector: Injector) {
        self.injector = injector
        self.testRepository = injector.testRepository()
        self.searchActressUseCase = injector.searchActressUseCase()
        self.searchActress(searchedKeyWord: "上原")
    }
    
    func searchActress(searchedKeyWord: String) {
        searchActressUseCase.searchActress(searchedKeyWord: searchedKeyWord, completionHandler: { response, error in
            response?.watch { [weak self] response in
                if let actresses = response?.result.actress {
                    self?.actresses = actresses
                }
                
            }
        })
    }
}
