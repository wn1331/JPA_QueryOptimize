package com.example.bigdatas;

import com.example.bigdatas.repository.BigDataParentsRepository;
import com.example.bigdatas.repository.BigDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final BigDataParentsRepository bigDataParentsRepository;
    private final BigDataRepository bigDataRepository;

    


}
