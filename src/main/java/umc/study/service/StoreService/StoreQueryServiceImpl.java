package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.StoreConverter;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.dto.storeDto.StoreRequestDto;
import umc.study.repository.RegionRepository.RegionRepository;
import umc.study.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreQueryServiceImpl {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    public void saveStore(StoreRequestDto storeRequestDto){
        Region region = regionRepository.findById(storeRequestDto.getRegion_id())
                        .orElseThrow(() -> new IllegalArgumentException("지역이 존재하지 않습니다"));

        Store store = StoreConverter.toEntity(storeRequestDto,region);

        storeRepository.save(store);
    }


    //@Override
    //public Optional<Store> findStore(Long id) {
        //return storeRepository.findById(id);
    //}

//    @Override
//    public List<Store> findStoresByNameAndScore(String name, Float score) {
//        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);
//
//        filteredStores.forEach(store -> System.out.println("Store: " + store));
//
//        return filteredStores;
//    }
}
