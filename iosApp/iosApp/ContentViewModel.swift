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
    
    private let testRepository: TestRepository
    
    init(testRepository: TestRepositoryImpl) {
        self.testRepository = testRepository
        self.searchActress(searchedKeyWord: "上原")
    }
    
    func searchActress(searchedKeyWord: String) {
        testRepository.searchActress(searchedKeyWord: searchedKeyWord, completionHandler: { response, error in
            response?.watch { [weak self] result in
                if let actresses = result?.result.actress {
                    self?.actresses = actresses
                }
            }
        })
    }
}
