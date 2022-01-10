package com.btc.app;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.btc.app.common.constant.ApiConstant;
import com.btc.app.model.Wallet;
import com.btc.app.repository.WalletRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class BtcBackendApiApplicationTests {
	
	ObjectMapper om = new ObjectMapper();
	
	@Autowired
	WalletRepository walletRepository;
	
    @Autowired
    MockMvc mockMvc;
    
    Map<String, Wallet> testData;

    @Before
    public void setup() throws ParseException {
    	walletRepository.deleteAll();
        testData = getTestData();
    }
    
    @Test
    public void testWalletCreationWithValidData() throws Exception {
    	
    	 Wallet expectedRecord = testData.get("wallet1");
    	 
    	 Wallet actualRecord = om.readValue(mockMvc.perform(post("/api/btc/wallets")
                 .contentType("application/json")
                 .content(om.writeValueAsString(expectedRecord)))
                 .andDo(print())
                 .andExpect(jsonPath("$.id", greaterThan(0)))
                 .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), Wallet.class);

         Assert.assertTrue(new ReflectionEquals(expectedRecord, "id").matches(actualRecord));
         assertEquals(true, walletRepository.findById(actualRecord.getId()).isPresent());
    	 
    	
    }
    
    @Test
    public void testGetWallet() throws  Exception {
    	
    	List<Wallet> actualRecords = om.readValue(mockMvc.perform(get("/api/btc/wallets/?startDatetime=2019-10-05T13:15:05+00:00&endDatetime=2022-10-05T20:15:05+00:00"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(), new TypeReference<List<Wallet>>() {
        });
    }
    
    private Map<String, Wallet> getTestData() throws ParseException {
        Map<String, Wallet> data = new HashMap<>();

        Date startDate = new SimpleDateFormat(ApiConstant.DATE_FORMAT).parse("2020-10-05T13:30:05+00:00");
        Timestamp datetime=new Timestamp(startDate.getTime());
        
        Wallet wallet1 = new Wallet(1000.0,datetime);
        data.put("wallet1", wallet1);
        
        Date startDate1 = new SimpleDateFormat(ApiConstant.DATE_FORMAT).parse("2021-10-05T14:45:05+07:00");
        Timestamp datetime1=new Timestamp(startDate1.getTime());
        
        Wallet wallet2 = new Wallet(1000.1,datetime1);
        data.put("wallet1", wallet2);
        
        Date startDate2 = new SimpleDateFormat(ApiConstant.DATE_FORMAT).parse("2022-01-01T12:30:05+00:00");
        Timestamp datetime2=new Timestamp(startDate2.getTime());
        
        Wallet wallet3 = new Wallet(1000.2,datetime2);
        data.put("wallet1", wallet3);

        


        return data;
    }

}
