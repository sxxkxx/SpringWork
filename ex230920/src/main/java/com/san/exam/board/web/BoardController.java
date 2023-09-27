package com.san.exam.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.san.exam.board.service.BoardService;
import com.san.exam.board.service.BoardVO;


@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	// 전체 조회 : URI - boardList / RETURN - board/boardList
	@GetMapping("boardList")
	public String getBoardList(Model model) {
		List<BoardVO> list = boardService.getBoardList();
		model.addAttribute("boardList", list);
		return "board/boardList";
	}

	// 단건 조회 : URI - boardInfo / Parameter - BoardVO / RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String getBoardInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", findVO);
		return "board/boardInfo";
	}

	// 등록 - 페이지 : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String insertBoardForm() {
		// 등록페이지를 호출할 때 미리 primary key를 보여야하는 경우 Model이 필요함 => selectKey 사용 안함
		// select key를 사용하지않을 경우 어케함????
		return "board/boardInsert";
	}

	// 등록 - 처리 : URI - boardInsert / Parameter - BoardVO / RETURN 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String insertBoardProcess(BoardVO boardVO, RedirectAttributes reattr) {
		boardService.insertBoardInfo(boardVO);
		return "redirect:boardList";
		// redirect = 컨트롤러 호출
	}

	// 수정 - 페이지 : URI - boardUpdate / Parameter - BoardVO / RETURN -
	// board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", findVO);
		return "board/boardUpdate";
	}

	// 수정 - 처리 : URI - boardUpdate / Parameter - BoardVO / RETURN - 실행결과
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> boardUpdateProcess(@RequestBody BoardVO boardVO) { // @RequestBody는 선택, @RequestBody사용시
																					// ajax, 아닐시 QueryString 사용
		Map<String, Object> map = new HashMap<>();
		int result = boardService.updateBoardInfo(boardVO);
		System.out.println(result);
		if (result > -1) {
			map.put("result", true);
			map.put("bno", result);
		} else {
			map.put("result", false);
		}
		return map;
	}

	// 삭제 - 처리 : URI - boardDelete / parameter - bno / return - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam Integer bno) {
		boardService.deleteBoardInfo(bno);
		return "redirect:boardList";
		// 컨트롤러를 실행
	}
}
