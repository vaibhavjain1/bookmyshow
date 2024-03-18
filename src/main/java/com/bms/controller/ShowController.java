/**
 * 
 */
package com.bms.controller;

import com.bms.dto.PageResponse;
import com.bms.dto.ShowDto;
import com.bms.service.ShowService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalTime;

@Log4j2
@RestController
@RequestMapping("show")
public class ShowController {

	@Autowired
	private ShowService showService;

	@GetMapping("/search/{pageNo}/{limit}")
	public ResponseEntity<PageResponse<ShowDto>> search(
			@PathVariable(name = "pageNo") @Min(value = 1, message = "Page No Cannot be less than 1") int pageNo,
			@PathVariable(name = "limit") @Min(value = 1, message = "Limit Cannot be less than 1") int limit,
			@RequestParam(name = "movieName", required = false) String movieName,
			@RequestParam(name = "city", required = false) String city,
			@RequestParam(name = "showDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate showDate,
			@RequestParam(name = "showTime", required = false) @DateTimeFormat(pattern = "HH:mm:ss") LocalTime showTime) {

		log.info("Received Request to search shows for Page: [Number: " + pageNo + ", Limit: " + limit + "]");

		return ResponseEntity.ok(showService.searchShows(movieName, city, showDate, showTime, pageNo, limit));
	}

	@PostMapping("add")
	public ResponseEntity<ShowDto> addShow(@RequestBody ShowDto showDto) {

		log.info("Received Request to add new show: " + showDto);

		return ResponseEntity.ok(showDto);
	}

}